package sam.info.designpatterns.concepts

import android.util.Log


//The inline keyword is useful for functions that accept other functions, or lambdas, as arguments.
inline fun sampleInline(funcType: () -> Any) {
    val output = funcType()
    Log.e("Function executed", "Output $output")
}

fun addInline(a: Int, b: Int): Int = a + b
fun subInline(a: Int, b: Int): Int = a - b
fun starInline(a: Int, b: Int): Int {
    Log.e("Star func", "Executed")
    return a * b
}