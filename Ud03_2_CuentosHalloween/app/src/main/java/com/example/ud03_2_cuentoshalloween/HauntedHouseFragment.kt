package com.example.ud03_2_cuentoshalloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class HauntedHouseFragment : Fragment() {    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_haunted_house, container, false)
        val name = SelectionFragmentArgs.fromBundle(requireArguments()).name

        return view
    }
}