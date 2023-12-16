package com.example.designpattersexm.designPattern.factoryPattern

import android.util.Log

class FactoryMethod {

    // Product interface
    interface Task {
        fun execute()
    }

    // Concrete Products
    class DownloadTask : Task {
        override fun execute() {
            println("Executing Download Task...")
            // Download logic
        }
    }

    class DelayTask: Task {
        override fun execute() {
            println("Execute ")
        }

    }

    class UploadTask : Task {
        override fun execute() {
            println("Executing Upload Task...")
            Log.d("MainAc", "Executing Upload Task...")
            // Upload logic
        }
    }

    // Creator abstract Class
    abstract class TaskCreator {
        abstract fun createTask(): Task
        fun taskManager(){
            val testTask= createTask()
            testTask.execute()
        }
    }

    // Concrete Creators
    class DownloadTaskCreator : TaskCreator() {
        override fun createTask(): Task {
            return DownloadTask()
        }
    }

    class UploadTaskCreator : TaskCreator() {
        override fun createTask(): Task {
            return UploadTask()
        }
    }

}