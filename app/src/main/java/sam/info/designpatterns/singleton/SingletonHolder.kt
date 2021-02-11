package sam.info.designpatterns.singleton

/**
 * Singleton Holder with double-checked locking system. (Similar to lazy function in kotlin)
 */

open class SingletonHolder<out T : Any, in A>(creator: (A) -> T) {

    private var creator: ((A) -> T)? = creator

    @Volatile
    private var instance: T? = null

    fun getInstance(arg: A): T {
        val firstInstance = instance
        if (firstInstance != null) {
            return firstInstance
        }
        return synchronized(this) {
            val secondInstance = instance
            if (secondInstance != null) {
                secondInstance
            } else {
                val created = creator!!(arg)
                instance = created
                creator = null
                created
            }
        }
    }
}

open class SingletonHolderNoArg<out T : Any>(creator: () -> T) {

    private var creator: (() -> T)? = creator

    @Volatile
    private var instance: T? = null

    fun getInstance(): T {
        val firstInstance = instance
        if (firstInstance != null) {
            return firstInstance
        }
        return synchronized(this) {
            val secondInstance = instance
            if (secondInstance != null) {
                secondInstance
            } else {
                val created = creator!!()
                instance = created
                creator = null
                created
            }
        }
    }
}