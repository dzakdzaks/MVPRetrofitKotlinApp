package com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate

import android.util.Log
import com.project.dzakdzak.retrofitkotlinapp.InitRetrofit
import com.project.dzakdzak.retrofitkotlinapp.ResponseInsert
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Dzaky on 23/08/2017.
 */
class PresenterCRUD {
    var presenterView: PresenterModel? = null

    constructor(presenterView: PresenterModel?) {
        this.presenterView = presenterView
    }

    fun Tambah(nama: String, nis: String,status : Int){
        if (nama.isNotEmpty() && nis.isNotEmpty()) {

            var getInit = InitRetrofit().getInitInstance()

            //Get Request
            var request = getInit.request_insert(nama, nis.toInt(),status)

            //Get Response

            request.enqueue(object : retrofit2.Callback<ResponseInsert> {

                override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    //progress.dismiss()
                    Log.d("Response Insert :", response?.message())

                    if (response != null) {
                        if (response.isSuccessful && response.body().status!!.equals("true")) {
                            var result = response.body()?.status
                            var msg = response.body()?.msg

                            presenterView?.Hasil(result!!, msg!!)
                        }
                    }
                }

                override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    // progress.dismiss()
                    Log.d("Error Insert", t.toString())
                }


            })
        }

    }


    fun Hapus(id: String) {
        var getInit = InitRetrofit().getInitInstance()

        //Get Request
        var request = getInit.request_delete(id)

        //Get Response

        request.enqueue(object : Callback<ResponseInsert> {

            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                //progress.dismiss()
                Log.d("Response Insert :", response?.message())

                if (response != null) {
                    if (response.isSuccessful && response.body().status.equals("true")) {
                        var result = response.body()?.status
                        var msg = response.body()?.msg

                        presenterView?.Hasil(result!!, msg!!)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                // progress.dismiss()
                Log.d("Error Insert", t.toString())
                presenterView?.Error(t.toString())
            }


        })
    }

    fun Update(id: String, nama: String, nis: String) {
        var getInit = InitRetrofit().getInitInstance()

        //Get Request
        var request = getInit.request_update(id, nama, nis)

        //Get Response

        request.enqueue(object : Callback<ResponseInsert> {

            override fun onResponse(call: Call<ResponseInsert>?, response: Response<ResponseInsert>?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                //progress.dismiss()
                Log.d("Response Insert :", response?.message())

                if (response != null) {
                    if (response.isSuccessful && response.body().status.equals("true")) {
                        var result = response.body()?.status
                        var msg = response.body()?.msg

                        presenterView?.Hasil(result!!, msg!!)
                    }
                }
            }

            override fun onFailure(call: Call<ResponseInsert>?, t: Throwable?) {
//                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                // progress.dismiss()
                Log.d("Error Insert", t.toString())
                presenterView?.Error(t.toString())
            }


        })
    }

}