package com.example.kotlinintermedio

class Programmer(name: String, age: Int, val language: String): Person(name, age), Vehicle{

    // override se usa para sobreescribir la funcion del padre
    override fun work() {
        // super se necesita poner para referir a su superclase (Person)
        // este codigo haria lo mismo que esta haciendo la clase padre
        // super.work()
        println("Esta persona esta programando")
        super.work()
    }

    fun sayLanguage() {
        println("Este programador usa el lenguage $language")
    }
    override fun goToWork() {
        println("Esta persona va a Google")
    }

    override fun drive() {
        println("Esta persona conduce un coche")
    }
}