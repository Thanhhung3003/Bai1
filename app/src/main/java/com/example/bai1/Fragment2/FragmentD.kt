package com.example.bai1.Fragment2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bai1.R

class FragmentD : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_fragment_d,container,false)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("D","onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("D","onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("D","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("D","onResume")
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("D", "onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("D", "onDetach")
    }

    override fun onPause() {
        super.onPause()
        Log.d("D", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("B", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("D", "onDestroy")
    }
}