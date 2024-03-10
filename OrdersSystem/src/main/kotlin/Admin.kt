class Admin(username: String, hashedPassword: String) : User(username, hashedPassword) {
    public fun AddNewDish(menu: Menu){
        menu.addDish();
    }

    public fun DeleteDish(menu: Menu){
        menu.deleteDish();
    }

    public fun EditDishes(menu: Menu){
        menu.EditDishes();
    }

}