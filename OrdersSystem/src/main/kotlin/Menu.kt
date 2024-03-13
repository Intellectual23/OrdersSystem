import kotlinx.serialization.Serializable

@Serializable
class Menu {
    var dishes: MutableList<Dish> = mutableListOf();

    init {
        if (dishes.size == 0) {
            dishes.add(Dish("CheeseBurger", 300, 5, 15))
            dishes.add(Dish("Double CheeseBurger", 450, 5, 20))
            dishes.add(Dish("French Fries", 150, 10, 10))
        }
    }

    public fun addDish() {
        print("Enter dish name: ")
        val name = readln();
        print("Enter dish cost: ")
        val cost: Int = readln().toInt()
        print("Enter dish quantity: ")
        val quantity: Int = readln().toInt()
        print("Enter difficulty in minutes: ")
        val difficulty: Int = readln().toInt()
        dishes.add(Dish(name, cost, quantity, difficulty));
        println("- Dish was added into the menu!")
    }

    public fun deleteDish() {
        showMenu();
        print("Choose a dish to delete: ")
        val dish = dishes[readln().toInt() - 1];
        println("Dish ${dish.name} was successfully deleted")
        dishes.remove(dish);
    }

    public fun EditDishes() {
        showMenu()
        print("Choose a dish to edit:")
        val dish = dishes[readln().toInt() - 1];
        dish.DishEditMode();
    }

    public fun showMenu() {
        for (i in 0..dishes.size - 1) {
            val dish = dishes[i];
            println("${i + 1}. ${dish.name}: ${dish.cost} - ${dish.quantity}\n")
        }
    }
}