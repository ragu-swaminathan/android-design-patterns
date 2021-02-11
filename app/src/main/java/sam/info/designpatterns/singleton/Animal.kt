package sam.info.designpatterns.singleton

import android.content.Context
import android.util.Log


class Animal private constructor(context: Context) {
    companion object : SingletonHolder<Animal, Context>(::Animal)

    fun someTask() {
        Log.e("some task in Animal", "Feeding animals")
    }
}