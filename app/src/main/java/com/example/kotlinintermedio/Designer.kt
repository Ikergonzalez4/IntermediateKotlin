package com.example.kotlinintermedio

class Designer(name: String, age: Int): Person(name, age) {

    override fun work() {
        // super se necesita poner para referir a su superclase (Person)
        // este codigo haria lo mismo que esta haciendo la clase padre
        // super.work()
        println("Esta persona esta diseñando")
        super.work()
    }
}