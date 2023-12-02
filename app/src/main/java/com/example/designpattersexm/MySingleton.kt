package com.example.designpattersexm

class MySingleton private constructor() {

    // instance
    companion object {
        @Volatile// ensures that the instance variable is always read from and written to the main memory,
        // preventing possible threading issues during the instance creation.
        private var instance: MySingleton? = null

        fun getInstance(): MySingleton {
            return instance ?: synchronized(this) // block ensures that only one instance of the singleton is created,
            // even in a multithreaded environment.
            {
                instance ?: MySingleton().also { instance = it }
            }
        }
    }

    // Other methods of singleton class
    fun doSomething() {
        println("Singleton is doing something")
    }
}

//  Pros and Cons
// P- gain a global access point to that instance, object is initialized only when it’s requested for the first time.
// C- Violates the Single Responsibility Principle, It may be difficult to unit test the client code,
// requires special treatment in a multithreaded environment