package com.project.dzakdzak.retrofitkotlinapp

import com.google.gson.annotations.SerializedName


class ResponseData {

    @SerializedName("data")
    var data: List<Datum>? = null

}
