package sam.info.designpatterns

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import sam.info.designpatterns.builder.Vehicle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        builderPat()
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
}