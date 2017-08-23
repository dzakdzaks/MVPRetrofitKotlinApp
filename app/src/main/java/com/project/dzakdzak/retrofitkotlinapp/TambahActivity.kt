package com.project.dzakdzak.retrofitkotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate.PresenterModel
import com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate.PresenterCRUD
import kotlinx.android.synthetic.main.activity_tambah.*

class TambahActivity : AppCompatActivity(), PresenterModel {


    //    var id: Long? = null
//    var nama: String? = null
//    var nis: Long? = null
    var presenter: PresenterCRUD? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah)

//        var progress = ProgressDialog(applicationContext)
//        progress.setMessage("Loading")
//        progress.show()

        presenter = PresenterCRUD(this)
        btnTambah.setOnClickListener {
            var name = edtNama.text.toString()
            var nis = edtNis.text.toString()
            presenter!!.Tambah(name, nis,1)

        }

    }
    override fun Hasil(result: String, msg: String) {
        if(result.equals("true")){
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext,msg, Toast.LENGTH_LONG).show()
        }
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {
        Log.d("Error Delete : ",error.toString())

        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
