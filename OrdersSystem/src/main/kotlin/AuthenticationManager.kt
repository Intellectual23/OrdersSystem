import User
import java.security.MessageDigest

object AuthenticationManager {
    public var currentUser: User? = null

    init {
        DataStorage.users.add(Admin("Admin", hashPassword("AdminPass")))
        DataStorage.users.add(Customer("Customer1", hashPassword("Pass1")))
        DataStorage.users.add(Customer("Customer2", hashPassword("Pass2")))
    }

    public fun registerUser() {
        print("Enter your username: ")
        val username = readln()
        print("Enter your password: ")
        val password = readln();
        print("Repeate your password: ")
        if (password == readln()) {
            print(
                "Choose user type:\n" +
                        "1 - Customer\n" +
                        "2 - Admin\n"
            )
            when (readln()) {
                "1" -> DataStorage.users.add(Customer(username, hashPassword(password)));
                "2" -> DataStorage.users.add(Admin(username, hashPassword(password)));
                else -> {
                    println("- Wrong option!")
                    return;
                }
            }
            println("- Registration successful!");
        } else {
            println("- Try again!")
        }
    }

    public fun loginUser() {
        print("Enter your username: ")
        val username = readln()
        print("Enter your password: ")
        val password = readln();
        val user = DataStorage.users.find { it.username == username }
        if (user != null && user.passwordCheck(hashPassword(password))) {
            currentUser = user;
            println("- Login successful!")
        } else {
            println("- Invalid username or password!")
        }
    }

    private fun hashPassword(password: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(password.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }
}