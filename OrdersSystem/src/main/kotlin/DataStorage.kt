import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File

@Serializable
object DataStorage {
    var users: MutableList<User> = mutableListOf<User>();
    var menu: Menu = Menu();
    var orders: MutableList<Order> = mutableListOf<Order>()
    var totalProfit: Int = 0;

    private val usersFile = File("files/users.json")
    private val menuFile = File("files/menu.json")
    private val ordersFile = File("files/orders.json")
    private val totalProfitFile = File("files/totalProfit.json")

    fun saveProgress() {
        saveUsers()
        saveMenu()
        saveOrders()
        saveTotalProfit()
        println("-Data was saved in files/data.json")
    }

    fun loadProgress() {
        users = loadUsers();
        menu = loadMenu();
        orders = loadOrders();
        totalProfit = loadTotalProfit();
        println("Data was loaded from files/data.json")
    }

    private fun saveOrders() {
        val ordersJson = Json.encodeToString(orders)
        ordersFile.writeText(ordersJson);
    }

    private fun saveMenu() {
        val menuJson = Json.encodeToString(menu)
        menuFile.writeText(menuJson);
    }

    private fun saveUsers() {
        val usersJson = Json.encodeToString(users)
        usersFile.writeText(usersJson);
    }

    private fun saveTotalProfit() {
        val totalProfitJson = Json.encodeToString(totalProfit)
        totalProfitFile.writeText(totalProfitJson);
    }

    private fun loadOrders(): MutableList<Order> {
        val dataJson = ordersFile.readText()
        return Json.decodeFromString(dataJson);
    }

    private fun loadMenu(): Menu {
        val dataJson = menuFile.readText()
        return Json.decodeFromString(dataJson);
    }

    private fun loadUsers(): MutableList<User> {
        val dataJson = usersFile.readText()
        return Json.decodeFromString(dataJson);
    }

    private fun loadTotalProfit(): Int {
        val dataJson = totalProfitFile.readText()
        return Json.decodeFromString(dataJson);
    }
}