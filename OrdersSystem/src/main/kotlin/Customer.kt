class Customer(username: String, hashedPassword: String) : User(username, hashedPassword) {

    var orders = mutableListOf<Order>();
    fun createOrder(orderManager: OrderManager) {
        var dishes = mutableListOf<Dish>()
        while (true) {
            orderManager.menu.showMenu()
            print("Choose a dish or enter \"next\" to create order: ")
            val data = readln();
            if (data == "next") {
                if (dishes.size == 0) {
                    print("- Your bucket is empty, choose at least one dish!")
                    continue;
                } else {
                    break;
                }
            }
            try {
                val dish = orderManager.menu.dishes[data.toInt() - 1]
                if (dish.quantity == 0) {
                    print("-This dish is over :( ")
                    continue;
                }
                dishes.add(dish);
                dish.quantity--;
            } catch (e: Exception) {
                print("-Incorrect input!")
            }
        }
        orderManager.createOrder(this, dishes);
    }

    fun addToOrder(orderManager: OrderManager) {
        println("Choose an order for a dish to add:")

        for (i in 0..orders.size - 1) {
            if (orders[i].status == OrderStatus.PROCESSING) {
                println("${i + 1}" + orders[i])
            }
        }
        val orderToAdd = orders[readln().toInt() - 1];
        orderManager.menu.showMenu();

        print("choose a dish to add: ")
        val dishToAdd = orderManager.menu.dishes[readln().toInt() - 1];
        orderManager.addToOrder(orderToAdd, dishToAdd);
    }

    fun cancelOrder(orderManager: OrderManager) {
        print("Choose an order to cancel:\n")

        for (i in 0..orders.size - 1) {
            if (orders[i].status == OrderStatus.COOKING) {
                println("${i + 1}. " + orders[i])
            }
        }

        val orderToCancel = orders[readln().toInt() - 1];
        if (orderToCancel.status != OrderStatus.COOKING) {
            print("-Incorrect order! Try again!")
            return;
        }
        orderManager.cancelOrder(orderToCancel);
    }

    fun pay() {
        print("Choose an order to pay:\n")

        for (i in 0..orders.size - 1) {
            if (orders[i].status == OrderStatus.READY && !orders[i].isPaid) {
                print("${i + 1}" + orders[i])
            }
        }
        val order = orders[readln().toInt() - 1];
        if(order.isPaid){
            println("-This order is already paid!")
            return;
        }
        order.isPaid = true;
        println("Order ${order.id} is paid")
    }
}