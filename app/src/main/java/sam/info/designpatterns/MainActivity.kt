package sam.info.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import sam.info.designpatterns.builder.Vehicle
import sam.info.designpatterns.singleton.Flower
import sam.info.designpatterns.singleton.FlowerNormal

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
        val instanceThree = FlowerNormal()
        val instanceFour = FlowerNormal()

        Log.e(
            "Not a Singleton ",
            "${instanceThree.hashCode()} , ${instanceFour.hashCode()} - ${instanceThree.equals(
                instanceFour
            )}, ${instanceThree == instanceFour} , ${instanceThree === instanceFour}"
        )
    }
}