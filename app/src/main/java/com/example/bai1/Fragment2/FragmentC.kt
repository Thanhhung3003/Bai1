package com.example.bai1.Fragment2

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bai1.R

class FragmentC : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_fragment_c,container,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("C","onCreate")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("C","onViewCreated")
    }

    override fun onStart() {
        super.onStart()
        Log.d("C","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("C","onResume")
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("C", "onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("C", "onDetach")
    }

    override fun onPause() {
        super.onPause()
        Log.d("C", "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("C", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("C", "onDestroy")
    }
}