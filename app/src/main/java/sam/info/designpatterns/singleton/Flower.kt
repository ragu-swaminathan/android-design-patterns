package sam.info.designpatterns.singleton

import android.util.Log

object Flower {
    //Object keyword is enough to make the class singleton
    //No need for synchronized key as object itself provide thread safety
    // companion object keywords are equivalent to static
    fun doSomeTask() {
        Log.e("TASK in Flower", "Task Executed")
    }
}
