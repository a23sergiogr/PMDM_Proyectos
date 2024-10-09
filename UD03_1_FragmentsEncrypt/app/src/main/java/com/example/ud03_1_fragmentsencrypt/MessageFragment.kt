package com.example.ud03_1_fragmentsencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController

class MessageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)

        val btnNext = view.findViewById<Button>(R.id.btnNext)
        val textMessage = view.findViewById<TextView>(R.id.textEnterEncryptedMessage)
        btnNext.setOnClickListener {
            view.findNavController().navigate(MessageFragmentDirections.actionMessageFragment2ToEncryptFragment2(textMessage.text.toString()))
        }
        //Inflar el diseño desde el fragmento
        return view
    }


}