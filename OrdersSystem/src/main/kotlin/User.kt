open class User(val username: String, private val hashedPassword: String) {
    public fun passwordCheck(givenHashedPassword: String): Boolean{
        return(hashedPassword == givenHashedPassword);
    }
}