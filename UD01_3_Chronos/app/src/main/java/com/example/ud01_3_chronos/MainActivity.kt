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
    private var pressBtn = 0

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY, running)
        outState.putLong(OFFSET_KEY, offset)
        outState.putLong(BASE_KEY, chronos.base)
        outState.putInt(PRESSBUTTON_KEY,pressBtn)
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

        //Buttons
        val btnStartResume = findViewById<Button>(R.id.buttonStartResume)
        val btnPause = findViewById<Button>(R.id.buttonPause)
        val btnStop = findViewById<Button>(R.id.buttonStop)

        if (savedInstanceState != null){
            running = savedInstanceState.getBoolean(RUNNING_KEY)
            offset = savedInstanceState.getLong(OFFSET_KEY)
            pressBtn = savedInstanceState.getInt(PRESSBUTTON_KEY)
            presButton(pressBtn,btnStartResume, btnPause, btnStop)

            if(running){
                chronos.base = savedInstanceState.getLong(BASE_KEY)
                chronos.start()
            }
            else{
                chronos.base = SystemClock.elapsedRealtime() - offset
            }
        }

        btnStartResume.setOnClickListener {
            if(!running){
                pressBtn = 0
                presButton(pressBtn,btnStartResume, btnPause, btnStop)
                chronos.base = SystemClock.elapsedRealtime() - offset
                chronos.start()
                running = true
            }
        }

        btnPause.setOnClickListener {
            if (running){
                pressBtn = 1
                presButton(pressBtn,btnStartResume, btnPause, btnStop)
                btnStartResume.text = getText(R.string.buttonResumeText)
                chronos.stop()
                running = false
                offset = SystemClock.elapsedRealtime() - chronos.base
            }
        }

        btnStop.setOnClickListener {
            pressBtn = 2
            presButton(pressBtn,btnStartResume, btnPause, btnStop)
            btnStartResume.text = getText(R.string.buttonStartText)
            offset = 0L
            chronos.base = SystemClock.elapsedRealtime()
            chronos.stop()
            running = false
        }
    }

    private fun presButton(n: Int, btnStartResume: Button, btnPause: Button, btnStop: Button){
        when (n) {
            0 -> colorChange(btnStartResume, btnPause, btnStop)
            1 -> colorChange(btnPause, btnStartResume, btnStop)
            2 -> colorChange(btnStop, btnPause, btnStartResume)
        }
    }
    private fun colorChange(pres: Button, nonPres: Button, nonPres2: Button){
        pres.backgroundTintList = getColorStateList(R.color.presButton)
        nonPres.backgroundTintList = getColorStateList(R.color.nonPresButton)
        nonPres2.backgroundTintList = getColorStateList(R.color.nonPresButton)
    }

    //Pasa a segundo Plano
    override fun onStop() {
        if (running){
            running
            offset = 0L
            chronos.base = SystemClock.elapsedRealtime()
            chronos.stop()
        }
        super.onStop()
    }

    //Vuelve a primer Plano
    override fun onRestart() {
        if(running){
            chronos.base = SystemClock.elapsedRealtime() - offset
            chronos.start()
        }
        super.onRestart()
    }

    override fun onPause() {
        if (running){
            offset = SystemClock.elapsedRealtime() - chronos.base
            chronos.stop()
        }
        super.onPause()
    }

    override fun onResume() {
        if(running){
            chronos.base = SystemClock.elapsedRealtime() - offset
            chronos.start()
        }
        super.onResume()
    }
}