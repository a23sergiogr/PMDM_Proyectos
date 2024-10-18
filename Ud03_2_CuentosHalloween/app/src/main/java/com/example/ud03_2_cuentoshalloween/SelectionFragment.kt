package com.example.ud03_2_cuentoshalloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.findNavController

class SelectionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val name = SelectionFragmentArgs.fromBundle(requireArguments()).name
        val view = inflater.inflate(R.layout.fragment_selection, container, false)

        val cardViewEnchantedForest: CardView = view.findViewById(R.id.cardViewEnchantedForest)
        val cardViewHauntedHouse: CardView = view.findViewById(R.id.cardViewHauntedHouse)

        cardViewEnchantedForest.setOnClickListener{
            val action = SelectionFragmentDirections.actionSelectionFragment2ToCuentoLosSusurrosDelBosqueEncantadoFragment(name)
            view.findNavController().navigate(action)
        }

        cardViewHauntedHouse.setOnClickListener {
        }

        return view
    }
}