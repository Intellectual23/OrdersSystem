import kotlinx.serialization.Serializable
import java.util.Dictionary
import javax.xml.crypto.Data

@Serializable
class Admin(override val username: String, override val hashedPassword: String) : User() {
    public fun addNewDish(menu: Menu) {
        menu.addDish();
    }

    public fun deleteDish(menu: Menu) {
        menu.deleteDish();
    }

    public fun editDishes(menu: Menu) {
        menu.EditDishes();
    }

    public fun showStats() {
        var averageRates = mutableMapOf<Dish, Float>();
        val orderCounts = mutableMapOf<Dish, Int>();
        for (order in DataStorage.orders) {
            if (order.review != null) {
                for (dish in order.dishes) {
                    if (!orderCounts.containsKey(dish)) {
                        orderCounts[dish] = 1;
                        averageRates[dish] = order.review!!.mark.toFloat();
                    } else {
                        orderCounts[dish] = orderCounts[dish]!! + 1;
                        averageRates[dish] = orderCounts[dish]!! + order.review!!.mark.toFloat();
                    }
                }
            }
        }
        val sortedRates = averageRates.toSortedMap(compareBy({ it.name }));
        println("-Current average dishes rate: ")
        for (dish in averageRates.keys) {
            averageRates[dish] = averageRates[dish]!! / orderCounts[dish]!!.toFloat();
            println("${dish.name} was ordered ${orderCounts[dish]} times, average rating: ${averageRates[dish]}/5")
        }
    }
}