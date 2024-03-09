import User
import java.security.MessageDigest

class AuthenticationManager {
    public var currentUser: User? = null
    private val users: MutableList<User> = mutableListOf();

    init {
        users.add(User("Admin", hashPassword("AdminPass"), UserType.ADMIN))
    }

    public fun registerUser(userType: UserType) {
        print("Enter your username: ")
        val username = readln()
        print("Enter your password: ")
        val password = readln();
        print("Repeate your password: ")
        if (password == readln()) {
            users.add(User(username, hashPassword(password), userType));
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
        val user = users.find { it.username == username }
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