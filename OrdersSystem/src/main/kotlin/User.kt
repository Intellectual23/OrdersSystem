import kotlinx.serialization.Serializable
@Serializable
sealed class User{
    abstract val username: String
    protected abstract val hashedPassword: String
    public fun passwordCheck(givenHashedPassword: String): Boolean {
        return (hashedPassword == givenHashedPassword);
    }
}