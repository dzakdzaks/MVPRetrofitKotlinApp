package com.project.dzakdzak.retrofitkotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate.PresenterList
import com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate.PresenterListModel
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity(), PresenterListModel {

    var presenterListTampil : PresenterList? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenterListTampil = PresenterList(this)


        imgTambah.setOnClickListener {
          startActivity(Intent(applicationContext, TambahActivity::class.java))
        }

        imgTambah2.setOnClickListener {
            startActivity(Intent(applicationContext, Tambah2Activity::class.java))
        }

        presenterListTampil?.dapatData()

        val dorefresh = findViewById(R.id.swipeRefresh) as SwipeRefreshLayout
        dorefresh.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light)

        /*event ketika widget dijalankan*/
        dorefresh.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                refreshItem()
            }

            internal fun refreshItem() {
                presenterListTampil?.dapatData()
                onItemLoad()
            }

            internal fun onItemLoad() {
                dorefresh.isRefreshing = false
            }

        })


    }
    override fun Hasil(result: List<Datum>) {
        //array to recyclerview

                        var adapter = Custom(this@MainActivity, result)
                        var linear = LinearLayoutManager(applicationContext)

                        recyclerView.adapter = adapter
                        recyclerView.layoutManager = linear

//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {
       // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}

