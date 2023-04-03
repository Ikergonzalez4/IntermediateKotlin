package com.example.kotlinintermedio

private class Visibility {

    var name: String? = null

    fun sayMyName() {
        name?.let {
            println("Mi nombre es $it")
        } ?: run {
            ("No tengo nombre")
        }
    }
}

open class VisibilityTwo {

    protected fun sayMyNameTwo() {

        val visibility = Visibility()

    }
}

class VisibilityThree: VisibilityTwo() {

    internal var age: Int? = null

    fun sayMyNameThree() {
        sayMyNameTwo()
    }

}