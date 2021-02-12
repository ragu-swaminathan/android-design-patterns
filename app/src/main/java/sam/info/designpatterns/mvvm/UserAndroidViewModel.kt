package sam.info.designpatterns.mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import sam.info.designpatterns.R
import sam.info.designpatterns.notifyObserver


class UserAndroidViewModel(application: Application) : AndroidViewModel(application) {

    private val usersLiveData = MutableLiveData<List<String>>()
    private val repo: DataRepo

    init {
        repo = DataRepo()
        Log.e(
            "Appname ", "in Androidviewmodel " +
                    application.applicationContext.resources.getString(R.string.app_name)
        )
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
