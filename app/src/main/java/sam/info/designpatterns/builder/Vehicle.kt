package sam.info.designpatterns.builder


class Vehicle(builder: Builder) {
    val carType = builder.getCarType()
    val carColor = builder.getColor()
    val engineType = builder.getEngine()
    val brand = builder.brand

    override fun toString(): String {
        return "A new ${engineType} engine, ${carColor} ${brand} ${carType} is manufactured successfully !! "
    }

    class Builder(val brand: String) {
        private var carType: String = "Sedan"
        private var carColor: String = "White"
        private var engineType = "Diesal"

        fun setCarType(type: String): Builder {
            carType = type
            return this
        }

        fun getCarType(): String {
            return carType
        }

        fun setColor(color: String): Builder {
            carColor = color
            return this
        }

        fun getColor(): String {
            return carColor
        }

        fun setEngine(engine: String): Builder {
            engineType = engine
            return this
        }

        fun getEngine(): String {
            return engineType
        }

        fun createCar(): Vehicle {
            return Vehicle(this)
        }
    }
}