package com.example.ud03_2_cuentoshalloween

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class SelectionFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mensageSinEncriptar = SelectionFragmentArgs.fromBundle(requireArguments()).name
        val view = inflater.inflate(R.layout.fragment_selection, container, false)



        return view
    }
}