package sam.info.designpatterns

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sam.info.designpatterns.builder.Vehicle
import sam.info.designpatterns.concepts.*
import sam.info.designpatterns.mvvm.CustomViewModel
import sam.info.designpatterns.mvvm.CustomViewModelFactory
import sam.info.designpatterns.mvvm.UserAndroidViewModel
import sam.info.designpatterns.mvvm.UserViewModel
import sam.info.designpatterns.singleton.Animal
import sam.info.designpatterns.singleton.AnimalLazy
import sam.info.designpatterns.singleton.Flower

class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel
    lateinit var customUserViewModel: CustomViewModel
    lateinit var userAndroidViewModel: UserAndroidViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickME = findViewById<TextView>(R.id.click_me)
        clickME.setOnClickListener {
            userViewModel.addUserData("${SystemClock.currentThreadTimeMillis()}")
        }
//        builderPat()
//        singleTonPat()
//        mvvmPat()
//        mvvmPatCustom()
//        mvvmPatAndroidVM()
        callInlineFunctions()
//        callGenericFunctions()
    }

    private fun builderPat() {
        //Standared way
        Vehicle.Builder("BMW").createCar().run {
            Log.e("BMW DETAIL", toString())
        }
        Vehicle.Builder("AUDI")
            .setColor("Blue")
            .setEngine("PETROL")
            .createCar().apply { Log.e("DETAIL", toString()) }
        Vehicle.Builder("BENZ")
            .setColor("Black")
            .setEngine("Diesal")
            .setCarType("Sports")
            .createCar().apply { Log.e("DETAIL", toString()) }

        // Kotlin way
        Vehicle.Builder("Ford").apply {
            setCarType("HEAVY")
            setColor("PINK")
        }.run {
            createCar()
        }.apply { Log.e("DETAILS", toString()) }
    }

    private fun singleTonPat() {
        val instanceOne = Flower
        val instanceTwo = Flower

        Log.e(
            "Singleton ",
            "${instanceOne.hashCode()} , ${instanceTwo.hashCode()} - ${
                instanceOne.equals(
                    instanceTwo
                )
            }, ${instanceOne == instanceTwo} , ${instanceOne === instanceTwo}"
        )

        // Using holder patterns
        Animal.getInstance(this).someTask()
        Log.e(
            "Singleton Holder ",
            "${Animal.hashCode()} , ${Animal.hashCode()} - ${
                Animal.getInstance(this) == Animal.getInstance(
                    this
                )
            } , ${Animal.getInstance(this) === Animal.getInstance(this)}\n${
                Animal.getInstance(this)
                    .hashCode()
            } , ${Animal.getInstance(this).hashCode()}"
        )
        AnimalLazy.instance.doTask()
        Log.e(
            "Singleton Lazy ",
            "${AnimalLazy.instance == AnimalLazy.instance} , ${AnimalLazy.instance === AnimalLazy.instance}\n${AnimalLazy.instance.hashCode()} , ${AnimalLazy.instance.hashCode()}"
        )
    }

    private fun mvvmPat() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.getUserDataLD().observe(this, Observer {
            Log.e("List size", "${it.size}")
        })
    }

    private fun mvvmPatCustom() {
        customUserViewModel =
            ViewModelProvider(this, CustomViewModelFactory(this, "Custom name passed")).get(
                CustomViewModel::class.java
            )

        customUserViewModel.getUserDataLD().observe(this, Observer {
            Log.e("customUserViewModel", "${it.size}")
        })
    }

    private fun mvvmPatAndroidVM() {
        userAndroidViewModel =
            ViewModelProvider(this).get(
                UserAndroidViewModel::class.java
            )

        userAndroidViewModel.getUserDataLD().observe(this, Observer {
            Log.e("customUserViewModel", "${it.size}")
        })
    }

    private fun callInlineFunctions() {
//        sampleInline { addInline(5, 6) }
//        sampleInline { starInline(5, 6) }
//        sampleNoInline({ addInline(5, 6) }, { starInline(5, 6)})
        sampleCrossInline({
            addInline(5, 6)
        }, {
            starInline(5, 6)
        })
    }

    private fun callGenericFunctions() {
        simpleGenerics("String Value")
        simpleGenerics(100)
        simpleGenericsWithClass(100, Int::class.java)
        simpleGenericsReified(100)
        simpleGenericsReified("OK OK ")
    }
}