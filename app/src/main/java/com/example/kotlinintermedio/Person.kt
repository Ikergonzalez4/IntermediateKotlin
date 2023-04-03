package com.example.kotlinintermedio

open class Person(name: String, age: Int) : Work(), Game{

    // open se usa para abrirlo, para que otras clases puedan sobreescribir la funcion
    open fun work() {
        println("Esta persona esta trabajando")
    }

    override fun goToWork() {
        println("Esta persona va al trabajo")
    }

    // Game interface

    override val game: String = "Among Us"

    override fun play() {
        println("Estoy haciendo stream de mi juego $game")
    }


}