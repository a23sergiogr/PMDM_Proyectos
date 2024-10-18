package com.example.ud03_2_cuentoshalloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

class CuentoLosSusurrosDelBosqueEncantadoFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_cuento_los_susurros_del_bosque_encantado, container, false)
        val name = SelectionFragmentArgs.fromBundle(requireArguments()).name

        val textView : TextView = view.findViewById(R.id.textStoryEnchantedForest)
        textView.text = textView.text.toString().replace("NAME",name)

        return view
    }
}