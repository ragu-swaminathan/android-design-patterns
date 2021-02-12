package sam.info.designpatterns.concepts

import android.util.Log


// Due to Type erasure type of G is unavailable
fun <G> simpleGenerics(value: G) {
    Log.e("Value simpleGenerics", "$value")
}

// Passing the class type along with generic is not suggested as it involves lot of boiler plate code
fun <G> simpleGenericsWithClass(value: G, classType: Class<G>) {
    Log.e("Value ", "$value , ${classType::class.java}")
}

// With the help of reified keyword we can get the information about the type of class
//Reified works with inline functions
inline fun <reified G> simpleGenericsReified(value: G) {
    Log.e("Value reified", "$value , ${G::class.java}")
}