package com.example.bai1.ListView

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.bai1.databinding.ListviewActivityBinding
import com.example.bai1.R

class ListViewActivity : AppCompatActivity() {
    lateinit var binding: ListviewActivityBinding
    var list: ArrayList<User> = ArrayList()
    lateinit var adapterUser: ApdapterUser
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ListviewActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapterUser = ApdapterUser(this,list)
        binding.btnDialog.setOnClickListener {
            DialogAdd()
        }

    }

    private fun DialogAdd() {
        var dialog : Dialog = Dialog(this)
        dialog.setContentView(R.layout.layout_add_user)
        dialog.setCanceledOnTouchOutside(false)
        var edtTen : EditText = dialog.findViewById(R.id.editTextTen)
        var edtTuoi : EditText = dialog.findViewById(R.id.editTextTuoi)
        var edtGTinh : EditText = dialog.findViewById(R.id.editTextGioitinh)
        var btnAdd : Button = dialog.findViewById(R.id.buttonAdd)
        var btnCancel : Button = dialog.findViewById(R.id.buttonCancel)
        btnAdd.setOnClickListener {
            list.add(User(edtTen.text.toString(),edtTuoi.text.toString().toInt(),edtGTinh.text.toString()))
            binding.lvUser.adapter = adapterUser
        }
        btnCancel.setOnClickListener {
            dialog.cancel()

        }
        dialog.show()

    }
}