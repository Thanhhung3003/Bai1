package com.example.bai1.Fragment1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bai1.R



class FragmentA: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_fragment_a,container,false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var btnReplace : Button = view.findViewById(R.id.btnchon)
        btnReplace.setOnClickListener {
            var fragmentB = FragmentB()
            requireActivity().supportFragmentManager
                .beginTransaction().replace(R.id.Frame_FragmentA,fragmentB)
                .addToBackStack(null)
                .commit()
        }
    }




}