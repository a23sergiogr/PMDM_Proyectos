package com.example.contactoslinearlayout

import android.os.Bundle
import android.text.Editable
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

        val txtLlamada = findViewById<TextView>(R.id.txtLlamada)
        val btnLlamar1 = findViewById<Button>(R.id.button)
        val btnLlamar2 = findViewById<Button>(R.id.button2)

        btnLlamar1.setOnClickListener {
            val textNombre = findViewById<TextView>(R.id.textNombre1)
            var str = getText(R.string.textLlamando).toString() + " " + textNombre.text
            txtLlamada.text = str
        }

        btnLlamar2.setOnClickListener {
            val textNombre2 = findViewById<TextView>(R.id.textNombre2)
            var str = getText(R.string.textLlamando).toString() + " " + textNombre2.text
            txtLlamada.text = str
        }
    }
}