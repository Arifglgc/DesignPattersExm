package com.example.designpattersexm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var taskCreator: FactoryMethod.TaskCreator

    private fun initialize(){
        val config= readApplicationConfigFile()

        taskCreator= when(config.task){
            "Upload"-> FactoryMethod.UploadTaskCreator()
            "Download" -> FactoryMethod.DownloadTaskCreator()
            else -> throw Exception("Error! Unknown task.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()
        taskCreator.taskManager()
    }

    fun readApplicationConfigFile(): Config {
        // Implement this method to read and return application configuration
        // You can replace it with your actual implementation.
        return Config("Upload") // Default configuration for the sake of the example.
    }

    data class Config(val task: String)

}





