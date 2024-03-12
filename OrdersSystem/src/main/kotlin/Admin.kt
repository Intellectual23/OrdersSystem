class Admin(username: String, hashedPassword: String) : User(username, hashedPassword) {
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