package sam.info.designpatterns.concepts

import android.util.Log

//The inline keyword is useful for functions that accept other functions, or lambdas, as arguments.
//Function call overhead doesn't occur. -> usage of memory, time and other resources.
//Time taken to run the code inside the fun is < calling a fun that contains code. (ns)
inline fun sampleInline(funcType: () -> Any) {
    val output = funcType()
    Log.e("Function executed", "Output $output")
}

//avoid the inlining
inline fun sampleNoInline(funcType: () -> Any, noinline funcType2: () -> Any) {
    val output = funcType()
    Log.e("sampleNoInline executed", "Output $output")
    val output2 = funcType2()
    Log.e("sampleNoInline executed", "Output $output2")
}
// crossinline can help us to avoid the "non-local returns".
inline fun sampleCrossInline( funcType: () -> Any, noinline funcType2: () -> Any) {
    val output = funcType()
    Log.e("sampleCrossInline", "Output $output")
    val output2 = funcType2()
    Log.e("sampleCrossInline", "Output $output2")
}

fun addInline(a: Int, b: Int): Int = a + b
fun subInline(a: Int, b: Int): Int = a - b
fun starInline(a: Int, b: Int): Int {
    Log.e("Star func", "Executed")
    return a * b
}