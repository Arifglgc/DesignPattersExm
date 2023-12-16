package com.example.designpattersexm


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.designpattersexm.designPattern.builder.MyComponent
import com.example.designpattersexm.designPattern.builder.MyComponent2
import com.example.designpattersexm.designPattern.builder.MyComponent3
import com.example.designpattersexm.designPattern.factoryPattern.FactoryMethod
import com.example.designpattersexm.designPattern.singleton.MySingleton
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

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//---------------FactoryDesignPattern-------------------------------
        initialize()
        taskCreator.taskManager()
//-----------------Singleton Design Pattern---------------------------
        val firstInitial= MySingleton.getInstance()
        val secondInitial= MySingleton.getInstance()
        val isSame = firstInitial == secondInitial
        Log.d("Singleton Test", isSame.toString())

//----------------Builder Design Pattern------------------------------
        val component1 = MyComponent.Builder()
            .setName("MyComponent v1.0")
            .setId(10)
            .setVisibility(true)
            .build()

        println(component1.name)

        val cmptNew= MyComponent.Builder()
            .setName("NoName")
            .build()

        println(cmptNew.name)


        val component2 = MyComponent2.Builder().apply {
            name = "Component Name"
            id = 1
            isVisible = true
        }.build()



        val component3= MyComponent3("MyName",10,true)

        val component4= MyComponent3("MySecondName",20,false,1.0f)




    }



    private fun readApplicationConfigFile(): Config {
        // Implement this method to read and return application configuration
        // You can replace it with your actual implementation.
        return Config("Upload") // Default configuration for the sake of the example.
    }

    data class Config(val task: String)

}





