package sam.info.designpatterns.mvvm

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sam.info.designpatterns.notifyObserver


class CustomViewModel(context: Context, name: String) : ViewModel() {

    private val usersLiveData = MutableLiveData<List<String>>()
    private val repo: DataRepo

    init {
        repo = DataRepo()
        Log.e("Name received in init", name)
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

class CustomViewModelFactory(private val context: Context, private val test: String) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CustomViewModel(context, test) as T
    }

}