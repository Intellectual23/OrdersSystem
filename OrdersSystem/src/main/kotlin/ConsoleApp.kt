class ConsoleApp {
    fun run() {
        while (true) {
            if (AuthenticationManager.currentUser == null) {
                print(
                    "Choose an option:\n" +
                            "0 - Load data from file\n" +
                            "1 - Register user\n" +
                            "2 - Login\n" +
                            "3 - Exit\n"
                )

                when (readln()) {
                    "0" -> DataStorage.loadProgress();
                    "1" -> AuthenticationManager.registerUser()
                    "2" -> AuthenticationManager.loginUser();
                    "3" -> {
                        print("- Do you want to save progress? [yes/no] :)")
                        when (readln()) {
                            "yes" -> DataStorage.saveProgress();
                            "no" -> {}
                            else -> println("- Wrong option!")
                        }
                        println("- Goodbye!")
                        break
                    }

                    else -> println("- Wrong option!")
                }
            } else if (AuthenticationManager.currentUser is Admin) {
                val admin = AuthenticationManager.currentUser as Admin;
                print(
                    "Choose an option:\n" +
                            "1 - Add new dish into the menu\n" +
                            "2 - Delete dish from the menu\n" +
                            "3 - Edit dish in menu\n" +
                            "4 - Show the menu\n" +
                            "5 - Show the orders/reviews statistics\n" +
                            "6 - Logout\n"
                )
                when (readln()) {
                    "1" -> admin.addNewDish(DataStorage.menu);
                    "2" -> admin.deleteDish(DataStorage.menu);
                    "3" -> admin.editDishes(DataStorage.menu);
                    "4" -> DataStorage.menu.showMenu();
                    "5" -> admin.showStats();
                    "6" -> {
                        AuthenticationManager.currentUser = null
                        println("- Logout successful!")
                    }

                    else -> println("- Wrong option!")
                }
            } else {
                val customer = AuthenticationManager.currentUser as Customer;
                print(
                    "Choose an option:\n" +
                            "1 - New Order\n" +
                            "2 - Add dish to Order\n" +
                            "3 - Delete Order\n" +
                            "4 - Pay for Order\n" +
                            "5 - Show Menu\n" +
                            "6 - Logout\n"
                )
                when (readln()) {
                    "1" -> customer.createOrder();
                    "2" -> customer.addToOrder();
                    "3" -> customer.cancelOrder();
                    "4" -> customer.pay();
                    "5" -> DataStorage.menu.showMenu()
                    "6" -> {
                        AuthenticationManager.currentUser = null
                        println("- Logout successful!")
                    }

                    else -> println("- Wrong option!")
                }
            }
        }
    }
}