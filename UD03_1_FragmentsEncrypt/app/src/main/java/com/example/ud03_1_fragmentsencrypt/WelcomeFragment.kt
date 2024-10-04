package com.example.ud03_1_fragmentsencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var btnStart = AppCompatActivity().findViewById<Button>(R.id.btnStart);

        btnStart.setOnClickListener {
            var mainLayout = AppCompatActivity().findViewById<androidx.fragment.app.FragmentContainerView>(R.id.main)
            btnStart.text = "sadasdasdsad"
        }
        //Inflar el diseño desde el fragmento
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }
}