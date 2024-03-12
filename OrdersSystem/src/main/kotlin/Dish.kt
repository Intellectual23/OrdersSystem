import kotlinx.serialization.Serializable
@Serializable
class Dish(var name: String, var cost: Int, var quantity: Int, var difficulty: Int) {

    fun DishEditMode() {
        while (true) {
            println(
                "Welcome to dish edit mode, choose an option:" +
                        "1 - Edit name" +
                        "2 - Edit cost" +
                        "3 - Edit quantity" +
                        "4 - Edit Difficulty in minutes" +
                        "5 - Exit edit mode"
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
        cost = readln().toInt();
        println("- Cost was changed successfully!")
    }

    private fun editQuantity() {
        print("Enter new quantity: ")
        quantity = readln().toInt();
        println("- Quantity was changed successfully!")
    }

    private fun editDifficulty() {
        print("Enter new difficulty in minutes: ")
        difficulty = readln().toInt();
        println("- Difficulty was changed successfully!")
    }
}