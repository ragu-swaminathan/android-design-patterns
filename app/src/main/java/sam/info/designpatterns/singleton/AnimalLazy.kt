package sam.info.designpatterns.singleton

import android.util.Log

/**
 * LAZY - initialized once and shared by all
 */
class AnimalLazy private constructor() {

    private object AnimalHolder {
        //        val INSTANCE = AnimalLazy() // Standared way
        val INSTANCE = SingletonHolderNoArg(::AnimalLazy) // Using holder pattern

    }

    companion object {
        val instance: AnimalLazy by lazy { AnimalHolder.INSTANCE.getInstance() }
    }

    fun doTask() {
        Log.e("Lazy", "Called")
    }
}