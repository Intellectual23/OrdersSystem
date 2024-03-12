import kotlinx.serialization.Serializable

@Serializable
class Admin(override val username: String, override val hashedPassword: String) : User() {
    public fun addNewDish(menu: Menu){
        menu.addDish();
    }

    public fun deleteDish(menu: Menu){
        menu.deleteDish();
    }

    public fun editDishes(menu: Menu){
        menu.EditDishes();
    }
}