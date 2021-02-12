package sam.info.designpatterns.mvvm

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import sam.info.designpatterns.R
import sam.info.designpatterns.notifyObserver

/**
 * You can also use Android View model if you need application context
 */
class CustomViewModel(context: Context, name: String) : ViewModel() {

    private val usersLiveData = MutableLiveData<List<String>>()
    private val repo: DataRepo

    init {
        repo = DataRepo()
        Log.e("Name received in init", name)
        Log.e("Appname", context.resources.getString(R.string.app_name))

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
        @Suppress("UNCHECKED_CAST")
        return CustomViewModel(context, test) as T
    }

}