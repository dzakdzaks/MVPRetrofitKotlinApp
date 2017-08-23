package com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate

import com.project.dzakdzak.retrofitkotlinapp.Datum

/**
 * Created by Dzaky on 23/08/2017.
 */
interface PresenterListModel {
    fun Hasil(result : List<Datum>)

    fun Error(error : String)
}