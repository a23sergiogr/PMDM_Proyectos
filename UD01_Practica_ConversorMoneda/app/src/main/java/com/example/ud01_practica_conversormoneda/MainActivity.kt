package com.example.ud01_practica_conversormoneda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
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
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnConvert = findViewById<Button>(R.id.btnConvert)
        val editTextNumberInput = findViewById<EditText>(R.id.editTextNumberInput)
        val editTextNumberOutput = findViewById<TextView>(R.id.textNumberOutput)

        btnConvert.setOnClickListener {
            val dolares = editTextNumberInput.text
            val euros = Integer.parseInt(dolares.toString()) * 2
            editTextNumberInput.text = dolares
            editTextNumberOutput.text = buildString {
                append(euros.toString())
                append("€")
            }
        }
    }
}