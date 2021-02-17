## Android Design patterns
Code snippet for commonly used design patterns in Android using Kotlin

### Builder pattern
A kind of pattern that we use to show alert dialog.
Pro Tip : https://www.jetbrains.com/help/idea/replace-constructor-with-builder.html#replace_constructorBuilder_example

### Singleton pattern

1. Using object keyword.
2. Using holder pattern
3. Using lazy initialization


### MVVM (Android specialist) with LiveData (Android Jetpack)
**Model - View - ViewModel**

**Model:** This is where we write all our Business logic and data state. All the data classes of our application are considered as Model.
```
data class Person(name:String){}
```

**View:** A typical user interface. Inflated with the help of XML as layouts.

**ViewModel:** Act as a bridge between the Model and the View. Contains UI logics. Manage the UI related complexities like data loss due to screen orientation.
 Ref : https://developer.android.com/topic/libraries/architecture/viewmodel

 Sample for MVVM with the following implementations
 1. Standared Viewmodel approach
 2. Viewmodel approach with params.


## Concepts
* Inline Functions
    * Keyword : **inline**
        * Accept other functions, or lambdas, as arguments.
        * Function call overhead doesn't occur. -> usage of memory, time and other resources.
        * Time taken to run the code inside the fun is < calling a fun that contains code. (ns)
    * Keyword : **noinline**
        * Avoid the function being inline
    * Keyword : **crossinline**
        * Help us to avoid the "non-local returns".

* Generics basics
    * Keyword : **reified**
