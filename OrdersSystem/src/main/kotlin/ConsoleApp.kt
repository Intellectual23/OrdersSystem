class ConsoleApp {
    private val manager = AuthenticationManager();
    private val orderManager = OrderManager(DataStorage.menu);
    fun run() {
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
                        print("- Do you want to safe progress? [yes/no] :)")
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
            } else if (manager.currentUser is Admin) {
                val admin = manager.currentUser as Admin;
                print(
                    "Choose an option:\n" +
                            "1 - Add new dish into the menu\n" +
                            "2 - Delete dish from the menu\n" +
                            "3 - Edit dish in menu\n" +
                            "4 - Show the menu\n" +
                            "5 - Logout\n"
                )
                when (readln()) {
                    "1" -> admin.addNewDish(DataStorage.menu);
                    "2" -> admin.deleteDish(DataStorage.menu);
                    "3" -> admin.editDishes(DataStorage.menu);
                    "4" -> DataStorage.menu.showMenu();
                    "5" -> {
                        manager.currentUser = null
                        println("- Logout successful!")
                    }

                    else -> println("- Wrong option!")
                }
            } else {
                val customer = manager.currentUser as Customer;
                print(
                    "Choose an option:\n " +
                            "1 - New Order\n" +
                            "2 - Add dish to Order\n" +
                            "3 - Delete Order\n" +
                            "4 - Pay for Order" +
                            "5 - Show Menu\n" +
                            "6 - Logout\n"
                )
                when (readln()) {
                    "1" -> customer.createOrder(orderManager);
                    "2" -> customer.addToOrder(orderManager);
                    "3" -> customer.cancelOrder(orderManager);
                    "4" -> customer.pay();
                    "5" -> {
                        manager.currentUser = null
                        println("- Logout successful!")
                    }

                    else -> println("- Wrong option!")
                }
            }
        }
    }
}