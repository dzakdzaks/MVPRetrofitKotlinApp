package com.project.dzakdzak.retrofitkotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_tambah2.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tambah2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah2)

        btnTambahGuru.setOnClickListener {
            var namaGuru = edtGuru.text.toString()
            var jurusan = edtJurusan.text.toString()

            if(namaGuru.isNotEmpty() && jurusan.isNotEmpty() ){
                var getInit = InitRetrofit().getInitInstance()
                var request = getInit.request_insert_guru(namaGuru,jurusan,1)

                request.enqueue(object : Callback<ResponseInsert>{
                    override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
                        Log.d("Response Insert :", response?.message())

                        if (response != null) {
                            if (response.isSuccessful && response.body().status!!.equals("true")){
                                startActivity(Intent(applicationContext,MainActivity::class.java))
                                finish()
                            }

                            //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

                        }
                    }

                    override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
                        Log.d("Error Insert", t.toString())

                        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
            }
        }
    }
}
