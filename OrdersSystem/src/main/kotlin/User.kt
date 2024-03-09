class User(val username: String, private val hashedPassword: String, public val userType: UserType) {
    public fun passwordCheck(givenHashedPassword: String): Boolean{
        return(hashedPassword == givenHashedPassword);
    }
}