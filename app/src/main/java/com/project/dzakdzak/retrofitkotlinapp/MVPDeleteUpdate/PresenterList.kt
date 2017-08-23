package com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate

import android.util.Log
import com.project.dzakdzak.retrofitkotlinapp.InitRetrofit
import com.project.dzakdzak.retrofitkotlinapp.ResponseData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by Dzaky on 23/08/2017.
 */
class PresenterList {
    var presenterList : PresenterListModel? = null

    constructor(presenterList: PresenterListModel?) {
        this.presenterList = presenterList
    }
     fun dapatData() {
        //get init
        var api = InitRetrofit().getInitInstance()
        //get request
        var call = api.request_getData()

        call.enqueue(object : Callback<ResponseData> {
            override fun onResponse(call: Call<ResponseData>?, response: Response<ResponseData>?) {
                Log.d("Response Get Data : ", response?.message())

                if (response != null) {
                    if(response.isSuccessful){
                        //grt json array data
                        var data = response.body()?.data
                        presenterList?.Hasil(data!!)


                    }

                }
            }

            override fun onFailure(call: Call<ResponseData>?, t: Throwable?) {
                Log.d("Error Get Data :", t.toString())
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })
     }
}