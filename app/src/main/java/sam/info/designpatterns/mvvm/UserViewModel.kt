package sam.info.designpatterns.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import sam.info.designpatterns.notifyObserver


class UserViewModel : ViewModel() {

    private val usersLiveData = MutableLiveData<List<String>>()
    private val repo: DataRepo

    init {
        repo = DataRepo()
    }

    fun getUserDataLD(): MutableLiveData<List<String>> {
        usersLiveData.postValue(repo.getUsers())
        return usersLiveData
    }

    fun addUserData(name: String) {
        repo.addUser(name)
        usersLiveData.notifyObserver()
    }
}

//class CustomViewModelFactory(private val test: String) : ViewModelProvider.NewInstanceFactory() {
//
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return UserViewModel(test) as T
//    }
//
//}