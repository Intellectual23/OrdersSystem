class ConsoleApp {
    val Manager = AuthenticationManager();
    public fun run() {
        while (true) {
            if (Manager.currentUser == null) {
                print(
                    "Choose an option:\n" +
                            "1 - Register user\n" +
                            "2 - Login\n" +
                            "3 - Exit\n"
                )

                when (readln()) {
                    "1" -> Manager.registerUser()
                    "2" -> Manager.loginUser();
                    "3" -> {
                        println("- Goodbye!")
                        break
                    }

                    else -> println("- Wrong option!")
                }
            }
            else {

            }
        }
    }
}