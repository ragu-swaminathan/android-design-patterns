package sam.info.designpatterns

import androidx.lifecycle.MutableLiveData


fun <T> MutableLiveData<T>.notifyObserver() {
    this.value = this.value
}