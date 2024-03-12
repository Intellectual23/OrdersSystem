import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import java.io.File

@Serializable
object DataStorage {
    var users = mutableListOf<User>();
    var menu = Menu();
    var orders = mutableListOf<Order>()
    var totalProfit = 0;
    private val dataFile = File("files/data.json")

    fun saveProgress(){
        val dataJson = Json.encodeToString(this);
        dataFile.writeText(dataJson);
        println("-Data was saved in files/data.json")
    }

    fun loadProgress(){
        val dataJson = dataFile.readText()
        val loadedData = Json.decodeFromString<DataStorage>(dataJson);
        users = loadedData.users;
        menu = loadedData.menu;
        orders = loadedData.orders;
        totalProfit = loadedData.totalProfit;
        println("Data was loaded from files/data.json")
    }
}