package sam.info.designpatterns.mvvm


class DataRepo {

    var userList = arrayListOf<String>()

    init {
        userList.add("User 1")
        userList.add("User 2")
        userList.add("User 3")
    }

    fun getUsers(): List<String> {
        return userList
    }

    fun addUser(user: String) {
        userList.add(user)
    }
}