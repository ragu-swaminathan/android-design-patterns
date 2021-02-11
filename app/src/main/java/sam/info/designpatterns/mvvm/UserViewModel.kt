package sam.info.designpatterns.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class UserViewModel : ViewModel() {

    private val usersLiveData = MutableLiveData<List<String>>()
    private val repo: DataRepo

    init {
        repo = DataRepo()
        usersLiveData.postValue(repo.getUsers())
    }

    fun getUserData(): LiveData<List<String>> {
        return usersLiveData
    }

    fun addUserData(name: String) {
        repo.addUser(name)
        usersLiveData.postValue(repo.getUsers())
    }
}

//class CustomViewModelFactory(private val test: String) : ViewModelProvider.NewInstanceFactory() {
//
//    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
//        return UserViewModel(test) as T
//    }
//
//}