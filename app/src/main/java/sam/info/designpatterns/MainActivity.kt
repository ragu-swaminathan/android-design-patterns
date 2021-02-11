package sam.info.designpatterns

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import sam.info.designpatterns.builder.Vehicle
import sam.info.designpatterns.mvvm.UserViewModel
import sam.info.designpatterns.singleton.Animal
import sam.info.designpatterns.singleton.AnimalLazy
import sam.info.designpatterns.singleton.Flower

class MainActivity : AppCompatActivity() {

    lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val clickME = findViewById<TextView>(R.id.click_me)
        clickME.setOnClickListener {
            userViewModel.addUserData("${SystemClock.currentThreadTimeMillis()}")
        }
//        builderPat()
//        singleTonPat()
        mvvmPat()
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
            "${instanceOne.hashCode()} , ${instanceTwo.hashCode()} - ${instanceOne.equals(
                instanceTwo
            )}, ${instanceOne == instanceTwo} , ${instanceOne === instanceTwo}"
        )

        // Using holder patterns
        Animal.getInstance(this).someTask()
        Log.e(
            "Singleton Holder ",
            "${Animal.hashCode()} , ${Animal.hashCode()} - ${Animal.getInstance(this) == Animal.getInstance(
                this
            )} , ${Animal.getInstance(this) === Animal.getInstance(this)}\n${Animal.getInstance(this)
                .hashCode()} , ${Animal.getInstance(this).hashCode()}"
        )
        AnimalLazy.instance.doTask()
        Log.e(
            "Singleton Lazy ",
            "${AnimalLazy.instance == AnimalLazy.instance} , ${AnimalLazy.instance === AnimalLazy.instance}\n${AnimalLazy.instance.hashCode()} , ${AnimalLazy.instance.hashCode()}"
        )
    }

    private fun mvvmPat() {
        userViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        userViewModel.getUserData().observe(this, Observer {
            Log.e("LIst size", "${it.size}")
        })
    }
}