import kotlin.concurrent.thread

object OrderManager {

    fun createOrder(customer: Customer, dishes: MutableList<Dish>) {
        val order = Order(DataStorage.orders.size + 1, customer.username, dishes);
        for (i in 0..order.dishes.size - 1) {
            order.totalCost += dishes[i].cost;
            order.totalDifficult += dishes[i].difficulty;
        }
        thread {
            println("--The order processing...")
            DataStorage.orders.add(order);
            customer.orders.add(order);
            Thread.sleep(15000);
            println("-The order successfully accepted!\n $order")
            order.orderThread.start();
        }
    }

    fun cancelOrder(order: Order) {
        if (order.status == OrderStatus.READY) {
            println("-The order is already cooked! You cannot cancel it!")
            return;
        } else {
            order.status = OrderStatus.CANCELED
            order.orderThread.interrupt()
            print("-Order was canceled!\n")
        }
    }

    fun addToOrder(order: Order, dish: Dish) {
        order.dishes.add(dish);
        order.totalCost += dish.cost;
        order.totalDifficult += dish.difficulty;
        println("-Dish ${dish.name} was added to order!");
    }

}