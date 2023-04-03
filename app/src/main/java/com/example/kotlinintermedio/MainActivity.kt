package com.example.kotlinintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

typealias MyMapList = MutableMap<Int, ArrayList<String>>
typealias MyFun = (Int, String, MyMapList) -> Boolean
typealias MyNestedClass = MyNestedAndInnerClass.MyNestedClass

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enumClasses()
        nestedAndInnerClasses()
        classInheritance()
        interfaces()
        visibilityModifiers()
        dataClasses()
        typeAliases()
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

        val myNestedClass = MyNestedClass() // llamada asi por typealias
        val sum = myNestedClass.sum(10, 5)
        println("El resultado de la suma es: $sum")

        val myInnerClass = MyNestedAndInnerClass().MyInnerClass() // sin typealias
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

    private fun interfaces() {

        val gamer = Person("Iker", 19)
        gamer.play()
        gamer.stream()
    }

    private fun visibilityModifiers() {

        //val visibility = Visibility()
        //visibility.name = "Iker"
        //visibility.sayMyName()

        val visibilityTwo = VisibilityTwo()
    }

    private fun dataClasses() {

        val iker = Worker("Iker Gonzalez", 19, "Programador")
        iker.lastWork = "Musico"

        val sara = Worker()

        val ikergonzalez = Worker("Iker", 19, "Programador")
        iker.lastWork = "Musico" // mismos datos que iker pero con otro nombre de val

        // equals & hashCode

        if(iker.equals(sara)) {             // no son iguales
            println("Son iguales")
        } else {
            println("No son iguales")
        }

        if(iker == ikergonzalez) {     // son iguales
            println("Son iguales")
        } else {
            println("No son iguales")
        }

        // toString
        println(iker.toString()) // permite ver los datos utilizados

        // copy
        val iker2 = iker.copy(age = 30) // copiar el objeto completo, cambiando la edad por 30
        println(iker.toString()) // mostrara ("Iker Gonzalez", 19, "Programador")
        println(iker2.toString()) // mostrara ("Iker Gonzalez", 30, "Programador")

        // componentN -- Permite descomponer los valores por propiedades
        val (name, age) = ikergonzalez
        println(name)
        print(age)
    }

    //private var myMap: MutableMap<Int, ArrayList<String>> = mutableMapOf() //sin crear typealias
    private var myMap: MyMapList = mutableMapOf()
    private fun typeAliases() {

        var myNewMap: MyMapList = mutableMapOf()
        myNewMap[1] = arrayListOf("Iker", "Gonzalez")
        myNewMap[2] = arrayListOf("ikergonzalez", "by ikergonzalez")

        myMap = myNewMap



    }

}