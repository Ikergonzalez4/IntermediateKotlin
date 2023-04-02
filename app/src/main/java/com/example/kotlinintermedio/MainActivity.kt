package com.example.kotlinintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enumClasses()
        nestedAndInnerClasses()
        classInheritance()
    }

    enum class Direction(val dir: Int) {

        NORTH(1), SOUTH(-1), EAST(1), WEST(-1);

        fun description() : String {

            return when (this) {
                NORTH -> "La direccion es NORTE"
                SOUTH -> "La direccion es SUR"
                EAST -> "La direccion es ESTE"
                WEST -> "La direccion es OESTE"
            }
            /*return when (this) {
                NORTH -> "La direccion es NORTE"
                SOUTH -> "La direccion es SUR"
                else -> "No sabemos la direccion"
            }*/
        }
    }

    private fun enumClasses() {

        var userDirection: Direction? = null
        println("Direccion: $userDirection")

        userDirection = Direction.NORTH
        println("Direccion: $userDirection")

        userDirection = Direction.EAST
        println("Direccion: $userDirection")

        println("Propiedad name: ${userDirection.name}") // Valor que esta tomando userDirection
        println("Propiedad name: ${userDirection.ordinal}") // Valor que esta tomando del enum {0,1,2..}

        println(userDirection.description())
        println(userDirection.dir)
    }

    private fun nestedAndInnerClasses() {

        val myNestedClass = MyNestedAndInnerClass.MyNestedClass()
        val sum = myNestedClass.sum(10, 5)
        println("El resultado de la suma es: $sum")

        val myInnerClass = MyNestedAndInnerClass().MyInnerClass()
        val sumTwo = myInnerClass.sumTwo(10)
        println("El resultado de sumar dos es $sumTwo")
    }
    private fun classInheritance() {

        val person = Person("Sara", 40)

        val programmer = Programmer("iker", 19, "Kotlin")
        programmer.work()
        programmer.sayLanguage()
        programmer.goToWork()
        programmer.drive()

        val designer = Designer("isabella", 18)
        designer.work()
        designer.goToWork()
    }
}