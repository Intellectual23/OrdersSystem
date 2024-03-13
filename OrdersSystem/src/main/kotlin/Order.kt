import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

@Serializable
class Order(val id: Int, val customerName: String, var dishes: MutableList<Dish>) {
    var status = OrderStatus.PROCESSING;
    var totalCost: Int = 0
    var totalDifficult: Int = 0
    var isPaid:Boolean = false;
    var review: Review? = null
    @Transient val orderThread = Thread {
        try {
            status = OrderStatus.COOKING;
            Thread.sleep(totalDifficult.toLong() * 1000); //Cooking
            print("-" + this.toString() + " is READY!\n")
            status = OrderStatus.READY;
        } catch (_: InterruptedException) {
        }
    }

    override fun toString(): String {
        return "order№${id}, client: ${customerName}, cost: ${totalCost}, time in minutes: ${totalDifficult}"
    }
}