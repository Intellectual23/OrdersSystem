import kotlinx.serialization.Serializable

@Serializable
class Dish(var name: String, var cost: Int, var quantity: Int, var difficulty: Int) {

    fun DishEditMode() {
        while (true) {
            println(
                "Welcome to dish edit mode, choose an option:\n" +
                        "1 - Edit name\n" +
                        "2 - Edit cost\n" +
                        "3 - Edit quantity\n" +
                        "4 - Edit Difficulty in minutes\n" +
                        "5 - Exit edit mode\n"
            )
            when (readln()) {
                "1" -> editName();
                "2" -> editCost();
                "3" -> editQuantity()
                "4" -> editDifficulty()
                "5" -> {
                    break
                };
                else -> println("- Wrong Option!");
            }
        }
    }

    private fun editName() {
        print("Enter new name: ")
        name = readln();
        println("- Name was changed successfully!")
    }

    private fun editCost() {
        print("Enter new cost: ")
        try {
            cost = readln().toInt();
            println("- Cost was changed successfully!")
        } catch (_: Exception) {
            println("- Incorrect input!")
        }
    }

    private fun editQuantity() {
        print("Enter new quantity: ")
        try {
            quantity = readln().toInt();
            println("- Quantity was changed successfully!")
        } catch (_: Exception) {
            println("- Incorrect input!")
        }
    }

    private fun editDifficulty() {
        print("Enter new difficulty: ")
        try {
            difficulty = readln().toInt();
            println("- Difficulty was changed successfully!")
        } catch (_: Exception) {
            println("- Incorrect input!")
        }
    }
}