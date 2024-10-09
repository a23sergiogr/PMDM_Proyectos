package com.example.ud03_1_fragmentsencrypt

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class EncryptFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mensageSinEncriptar = EncryptFragmentArgs.fromBundle(requireArguments()).message

        val mensageEncriptado = encrypt(mensageSinEncriptar)

        val view = inflater.inflate(R.layout.fragment_encrypt, container, false)

        val textView = view.findViewById<TextView>(R.id.textEncryptedMessage)
        textView.text = mensageEncriptado

        //Inflar el diseño desde el fragmento
        return view
    }

    private fun encrypt(str: String): String{
        val sb = StringBuilder()
        for (i in str.indices) {
            sb.append(str[str.length-i-1] + 3)
        }
        return sb.toString()
    }
    fun decrypt(str: String): String{
        val sb = StringBuilder()
        for (i in str.indices) {
            sb.append(str[str.length-i-1] - 3)
        }
        return sb.toString()
    }
}