package com.example.bai1.Fragment2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.bai1.R

class FragmentContainerViewD : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_containerviewt_d,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnaddB : (Button) = view.findViewById(R.id.btnAddD)
        btnaddB.setOnClickListener {
            val fragmentD = FragmentD()
            requireActivity().supportFragmentManager.beginTransaction()
                .add(R.id.FrameAdd_D,fragmentD)
                .commit()
        }
    }
}