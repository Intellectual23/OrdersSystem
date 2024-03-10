class Dish(var name: String, var cost: Int, var quantity: Int, var difficultInMinutes: Int) {

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
                "1" -> EditName();
                "2" -> EditCost();
                "3" -> EditQuantity()
                "4" -> EditDifficulty()
                "5" -> {
                    break
                };
                else -> println("- Wrong Option!");
            }
        }
    }

    private fun EditName() {
        print("Enter new name: ")
        name = readln();
        println("- Name was changed successfully!")
    }

    private fun EditCost() {
        print("Enter new cost: ")
        cost = readln().toInt();
        println("- Cost was changed successfully!")
    }

    private fun EditQuantity() {
        print("Enter new quantity: ")
        quantity = readln().toInt();
        println("- Quantity was changed successfully!")
    }

    private fun EditDifficulty() {
        print("Enter new difficulty in minutes: ")
        quantity = readln().toInt();
        println("- Difficulty was changed successfully!")
    }
}