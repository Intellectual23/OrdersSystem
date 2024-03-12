import kotlinx.serialization.Serializable
@Serializable
enum class OrderStatus {
    PROCESSING,
    COOKING,
    READY,
    CANCELED
}