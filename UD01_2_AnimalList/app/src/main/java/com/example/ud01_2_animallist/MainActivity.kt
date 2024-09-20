package com.example.ud01_2_animallist

import android.os.Bundle
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val btnSend = findViewById<Button>(R.id.buttonSend)
        btnSend.setOnClickListener {
            val spinnerAnimalType = findViewById<Spinner>(R.id.spinnerAnimalList)
            val textKindAnimal = findViewById<TextView>(R.id.textKindsAnimals)
            textKindAnimal.text = "Has seleccionado el ${spinnerAnimalType.selectedItemId}\n ${getAnimalKind(spinnerAnimalType.selectedItemId)}"
            /*
            """Has seleccionado el ${spinnerAnimalType.selectedItemId}
            ${this.getAnimalKind(id = spinnerAnimalType.selectedItemId)}"""
            .also { textKindAnimal.text = it }
            */
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun getAnimalKind(id:Long) = when (id){
        0L -> listOf("Chiguagua", "Pastor Alemán")
        1L -> listOf("Persa", "Egipcio")
        2L -> listOf("Mallard", "White call")
        else -> listOf()
    }
}