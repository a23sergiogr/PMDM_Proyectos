package com.example.ud01_3_chronos

import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private val RUNNING_KEY = "running"
    private val OFFSET_KEY = "offset"
    private val BASE_KEY = "base"
    private val PRESSBUTTON_KEY = "presButton"

    private lateinit var chronos : Chronometer
    private var running = false
    private var offset = 0L

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY, running)
        outState.putLong(OFFSET_KEY, offset)
        outState.putLong(BASE_KEY, chronos.base)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //chronos init
        chronos = findViewById(R.id.chronos)

        if (savedInstanceState != null){
            running = savedInstanceState.getBoolean(RUNNING_KEY)
            offset = savedInstanceState.getLong(OFFSET_KEY)
            if(running){
                chronos.base = savedInstanceState.getLong(BASE_KEY)
                chronos.start()
            }
            else{
                chronos.base = SystemClock.elapsedRealtime() - offset
            }
        }

        //Buttons
        val btnStartResume = findViewById<Button>(R.id.buttonStartResume)
        val btnPause = findViewById<Button>(R.id.buttonPause)
        val btnStop = findViewById<Button>(R.id.buttonStop)


        btnStop.backgroundTintList = getColorStateList(R.color.presButton)
        btnStartResume.setOnClickListener {
            if(!running){
                colorChange(btnStartResume, btnPause, btnStop)
                chronos.base = SystemClock.elapsedRealtime() - offset
                chronos.start()
                running = true
            }
        }

        btnPause.setOnClickListener {
            if (running){
                colorChange(btnPause, btnStartResume, btnStop)
                btnStartResume.text = getText(R.string.buttonResumeText)
                chronos.stop()
                running = false
                offset = SystemClock.elapsedRealtime() - chronos.base
            }
        }

        btnStop.setOnClickListener {
            colorChange(btnStop, btnPause, btnStartResume)
            btnStartResume.text = getText(R.string.buttonStartText)
            offset = 0L
            chronos.base = SystemClock.elapsedRealtime()
            chronos.stop()
            running = false
        }
    }

    private fun colorChange(pres: Button, nonPres: Button, nonPres2: Button){
        pres.backgroundTintList = getColorStateList(R.color.presButton)
        nonPres.backgroundTintList = getColorStateList(R.color.nonPresButton)
        nonPres2.backgroundTintList = getColorStateList(R.color.nonPresButton)
    }
}