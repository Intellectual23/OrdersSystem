class ConsoleApp {
    val manager = AuthenticationManager();
    val menu = Menu();
    public fun run() {
        while (true) {
            if (manager.currentUser == null) {
                print(
                    "Choose an option:\n" +
                            "1 - Register user\n" +
                            "2 - Login\n" +
                            "3 - Exit\n"
                )

                when (readln()) {
                    "1" -> manager.registerUser()
                    "2" -> manager.loginUser();
                    "3" -> {
                        println("- Goodbye!")
                        break
                    }

                    else -> println("- Wrong option!")
                }
            } else if(manager.currentUser is Admin) {
                val admin = manager.currentUser as Admin;
                print("Choose an option:\n" +
                        "1 - Add new dish into the menu\n" +
                        "2 - Delete dish from the menu\n" +
                        "3 - Edit dish in menu\n" +
                        "4 - Show the menu\n" +
                        "5 - Logout\n")
                when(readln()){
                    "1" -> admin.AddNewDish(menu);
                    "2" -> admin.DeleteDish(menu);
                    "3" -> admin.EditDishes(menu);
                    "4" -> menu.showMenu();
                    "5" -> {
                        manager.currentUser = null
                        println("- Logout successful!")
                    }
                }
            } else {
                val customer = manager.currentUser as Customer;
            }
        }
    }
}