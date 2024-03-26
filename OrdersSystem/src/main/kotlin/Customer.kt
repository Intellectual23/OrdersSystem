import kotlinx.serialization.Serializable

@Serializable
class Customer(override val username: String, override val hashedPassword: String) : User() {
    val orders = mutableListOf<Order>()
    fun createOrder() {
        val dishes = mutableListOf<Dish>()
        while (true) {
            DataStorage.menu.showMenu()
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
                val dish = DataStorage.menu.dishes[data.toInt() - 1]
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
        OrderManager.createOrder(this, dishes);
    }

    fun addToOrder() {
        println("Choose an order for a dish to add or \"back\":")

        for (i in 0..DataStorage.orders.size - 1) {
            if (DataStorage.orders[i].status == OrderStatus.PROCESSING) {
                println("${i + 1}" + DataStorage.orders[i])
            }
        }
        try {
            val data = readln()
            if (data == "back") {
                return;
            }
            val orderToAdd = DataStorage.orders[data.toInt() - 1];
            DataStorage.menu.showMenu();

            print("choose a dish to add: ")
            val dishToAdd = DataStorage.menu.dishes[readln().toInt() - 1];
            if (dishToAdd.quantity == 0) {
                print("-There are no dish left! Try another one.")
                return;
            }
            dishToAdd.quantity -= 1;
            OrderManager.addToOrder(orderToAdd, dishToAdd);
        } catch (_: Exception) {
            print("-Incorrect input!")
        }
    }

    fun cancelOrder() {
        print("Choose an order to cancel:\n")

        for (i in 0..DataStorage.orders.size - 1) {
            if (DataStorage.orders[i].status == OrderStatus.COOKING) {
                println("${i + 1}. " + DataStorage.orders[i])
            }
        }

        val orderToCancel = DataStorage.orders[readln().toInt() - 1];
        if (orderToCancel.status != OrderStatus.COOKING) {
            print("-Incorrect order! Try again!")
            return;
        }
        OrderManager.cancelOrder(orderToCancel);
    }

    fun pay() {
        print("Choose an order to pay:\n")

        for (i in 0..DataStorage.orders.size - 1) {
            if (DataStorage.orders[i].status == OrderStatus.READY) {
                print("${i + 1}. " + DataStorage.orders[i] + ":\n")
            }
        }

        val order = DataStorage.orders[readln().toInt() - 1];
        if (order.isPaid) {
            println("- This order is already paid!")
            return;
        }
        DataStorage.totalProfit += order.totalCost;
        order.isPaid = true;
        println("- Order ${order.id} is paid")
        println("Do you want to write a review? [yes/no]: ")
        when (readln()) {
            "yes" -> writeReview(order)
        }
    }

    private fun writeReview(order: Order) {
        var mark = 1;
        while (true) {
            print("Enter your mark from 1 to 5: ")
            try {
                mark = readln().toInt();
                if (mark <= 0 || mark >= 5) {
                    println("- Incorrect mark! Try again.")
                    continue;
                }
                break;
            } catch (_: Exception) {
                println("- Incorrect mark! Try again.")
                continue;
            }
        }
        print("Write a comment: ")
        order.review = Review(mark, readln());
    }
}