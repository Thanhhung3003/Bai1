package com.example.bai1.ListView

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.bai1.R

class ApdapterUser(var context: Context, var arrayList: ArrayList<User>):BaseAdapter() {
    override fun getCount(): Int {
        return arrayList.size
    }

    override fun getItem(p0: Int): Any {
        return arrayList.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return  p0.toLong()
    }
    class ViewHolder(row: View){
        val hoTen : TextView = row.findViewById(R.id.tvTen)
        val Tuoi : TextView = row.findViewById(R.id.tvTuoi)
        val gTinh : TextView = row.findViewById(R.id.tvGioiTinh)
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View? {
        var view: View?
        var viewHolder: ViewHolder
        if (p1 == null){
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.layout_user,null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = p1
            viewHolder = view.tag as ViewHolder
        }
        var user = getItem(p0) as User
        viewHolder.hoTen.text = user.hoTen
        viewHolder.Tuoi.text = user.Tuoi.toString()
        viewHolder.gTinh.text = user.gioiTinh
        return view
    }

}