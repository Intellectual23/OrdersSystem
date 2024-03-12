import kotlin.concurrent.thread

class Order(val id: Int, val customer: Customer, var dishes: MutableList<Dish>) {
    var status = OrderStatus.PROCESSING;
    var totalCost: Int = 0
    var totalDifficult: Int = 0
    var isPaid = false;
    val orderThread = Thread {
        try {
            status = OrderStatus.COOKING;
            Thread.sleep(totalDifficult.toLong() * 1000); //Cooking
            print("-" + this.toString() + "is READY!")
            status = OrderStatus.READY;
        } catch (_: InterruptedException) {
        }
    }

    override fun toString(): String {
        return "order№${id}, client: ${customer.username}, cost: ${totalCost}, time in minutes: ${totalDifficult}"
    }
}