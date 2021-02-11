package sam.info.designpatterns

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import sam.info.designpatterns.builder.Vehicle
import sam.info.designpatterns.singleton.Animal
import sam.info.designpatterns.singleton.AnimalLazy
import sam.info.designpatterns.singleton.Flower

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        builderPat()

        singleTonPat()
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
}