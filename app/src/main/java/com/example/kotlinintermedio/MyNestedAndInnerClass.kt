package com.example.kotlinintermedio

class MyNestedAndInnerClass {

    private val one = 1

    private fun returnOne() : Int {
        return one
    }

    class MyNestedClass {

        fun sum(first:Int, second: Int) : Int {
            return first + second
        }
    }

    inner class MyInnerClass {

        fun sumTwo(number: Int) : Int {
            return number + one + returnOne()
        }
    }
}