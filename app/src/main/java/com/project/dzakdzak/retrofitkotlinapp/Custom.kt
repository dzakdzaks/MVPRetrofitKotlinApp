package com.project.dzakdzak.retrofitkotlinapp

import android.app.Activity
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Dzaky on 23/08/2017.
 */
class Custom : RecyclerView.Adapter<Custom.MyHolder>{


    var c: Activity? = null
    var dataa: List<Datum>? = null

    constructor(mainActivity: MainActivity, data: List<Datum>?){
        this.c = mainActivity
        this.dataa = data
    }


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        var view = LayoutInflater.from(c).inflate(R.layout.list_item, parent,false)
        return MyHolder(view)
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder?.tvNama?.text = dataa?.get(position)!!.nama
        holder?.tvNis?.text = dataa?.get(position)!!.nis.toString()
        holder?.tvUpdate?.setOnClickListener {
            var intent = Intent(c, UpdateDelete::class.java)
             // intent.putExtra("posisi",position)
            intent.putExtra("id", dataa?.get(position)?.id)
            intent.putExtra("nama", dataa?.get(position)?.nama)
            intent.putExtra("nis", dataa?.get(position)?.nis)
            c?.startActivity(intent)
        }
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return dataa?.size!!
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class MyHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tvNama : TextView? = itemView?.findViewById(R.id.listName) as TextView
        var tvNis : TextView? = itemView?.findViewById(R.id.listNis) as TextView
        var tvUpdate : TextView? = itemView?.findViewById(R.id.listUpdate) as TextView
    }


}