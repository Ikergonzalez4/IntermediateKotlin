package com.example.kotlinintermedio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.thread
import kotlin.math.ln

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
        destructuringDeclarations()
        extensions()
        lambdas()
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

    private fun destructuringDeclarations() {

        //var iker = Worker("iker", 19, "Programador")
        val (name, age, work) = Worker("iker", 19, "Programador")
        println("$name ,$age, $work")

        /*val (name, _, work) = Worker("iker", 19, "Programador") "_" para ver name y work sin age
        println("$name, $work")*/

        val ikergonzalez = Worker("ikergonzalez", 20, "Programador")
        println(ikergonzalez.component1())

        val (ikerName, ikerAge, ikerWork) = myWorker()
        println("$ikerName, $ikerAge, $ikerWork")

        val myMap = mapOf(1 to "iker", 2 to "ana", 3 to "sara")
        for ((id, name) in myMap) {
            println("$id, $name")
        }
    }

    private fun myWorker(): Worker {
        return Worker("iker", 19, "Programador")
    }

    private fun extensions() {

        val myDate = Date()
        println(myDate.customFormat())
        println(myDate.formatSize)


        var myDateNullable: Date? = null
        println(myDateNullable.customFormat())
        println(myDateNullable.formatSize)
    }

    private fun lambdas() {

        val myIntList = arrayListOf(0,1,2,3,4,5,6,7,8,9,10)
        val myFilterIntList = myIntList.filter {myInt ->

            print(myInt)
            if (myInt == 1) {
                return@filter true
            }

            myInt > 5
        }
        print(myFilterIntList)

        val mySumFun = fun (x: Int, y: Int): Int = x + y // simplificamos la funcion y olvida return
        val myMultFun = fun (x: Int, y: Int): Int = x * y

        println(myOperateFun(5, 10, mySumFun))
        println(myOperateFun(5, 10, myMultFun))
        println(myOperateFun(5, 10) { x, y -> x - y })

        myAsincFun("iker") {
            println(it)
        }
    }

    private fun myOperateFun(x: Int, y: Int, myFun: (Int, Int) -> Int): Int {
        return myFun(x,y)
    }

    private fun myAsincFun(name: String, hello: (String) -> Unit) {

        val myNewString = "Hello $name!"
        hello(myNewString)

        thread {
            Thread.sleep(1000)
            hello(myNewString)
        }
        thread {
            Thread.sleep(5000)
            hello(myNewString)
        }
        thread {
            Thread.sleep(7000)
            hello(myNewString)
        }
    }
}
