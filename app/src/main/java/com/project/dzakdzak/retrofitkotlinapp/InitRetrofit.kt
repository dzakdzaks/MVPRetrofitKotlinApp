package com.project.dzakdzak.retrofitkotlinapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * Created by Dzaky on 22/08/2017.
 */
class InitRetrofit {

    //function untuk inisialize Retrofit
    fun getInitRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("http://192.168.20.159/lumen-api24/public/").addConverterFactory(GsonConverterFactory.create()).build()
    }

    fun getInitInstance() : ApiService{
        return getInitRetrofit().create(ApiService::class.java)
    }
}

interface ApiService{
    //GET
    @GET("input-siswa")
    fun request_insert(
            @Query("nama") nama : String,
            @Query("nis") nis : Int,
            @Query("status") status : Int
    ) : Call<ResponseInsert>

    @GET("get-siswa")
    fun request_getData() : Call<ResponseData>

    @FormUrlEncoded
    @POST("update-siswa")
    fun request_update(@Field("id")id : String,
                       @Field("nama")nama: String,
                       @Field("nis")nis: String): Call<ResponseInsert>
    @FormUrlEncoded
    @POST("delete-siswa")
    fun request_delete(@Field("id")id : String): Call<ResponseInsert>

    @GET("input-guru")
    fun request_insert_guru(
            @Query("nama_guru") namaGuru : String,
            @Query("jurusan") jurusan : String,
            @Query("status") status : Int
    ) : Call<ResponseInsert>


}
