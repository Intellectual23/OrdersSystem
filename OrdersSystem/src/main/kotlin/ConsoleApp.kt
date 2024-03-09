class ConsoleApp {
    val Manager = AuthenticationManager();
    public fun run() {
        while (true) {
            if (Manager.currentUser == null) {
                print(
                    "Choose an option:\n" +
                            "1 - Register Customer\n" +
                            "2 - Register Admin\n" +
                            "3 - Login\n" +
                            "4 - Exit\n"
                )

                when (readln()) {
                    "1" -> Manager.registerUser(UserType.CUSTOMER)
                    "2" -> Manager.registerUser(UserType.ADMIN)
                    "3" -> Manager.loginUser();
                    "4" -> {
                        println("- Goodbye!")
                        break
                    }

                    else -> println("- Wrong option!")
                }
            }
            else{
                
            }
        }
    }
}