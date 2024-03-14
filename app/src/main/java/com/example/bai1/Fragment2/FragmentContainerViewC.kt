package com.example.bai1.Fragment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bai1.R

class FragmentContainerViewC: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_containerviewt_c,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnaddA : (Button) = view.findViewById(R.id.btnAddC)
        btnaddA.setOnClickListener {
            val fragmentC = FragmentC()
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.FrameAdd_C,fragmentC)
                .commit()
        }
    }
}