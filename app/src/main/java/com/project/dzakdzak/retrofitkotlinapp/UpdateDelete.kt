package com.project.dzakdzak.retrofitkotlinapp

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate.PresenterModel
import com.project.dzakdzak.retrofitkotlinapp.MVPDeleteUpdate.PresenterCRUD
import kotlinx.android.synthetic.main.activity_update_delete.*

class UpdateDelete : AppCompatActivity(), PresenterModel {


    //deklarasi variabel unuk penampung index
    var id: Long? = null
    var nama: String? = null
    var nis: Long? = null
    var presenter: PresenterCRUD? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_delete)

        id = intent.getLongExtra("id", 0)
        nama = intent.getStringExtra("nama")
        nis = intent.getLongExtra("nis", 0)

        txtId.setText("ID Siswa : " + id.toString())
        edtNamaEdit.setText(nama)
        edtNisEdit.setText(nis.toString())

        var updateNama = edtNamaEdit.text
        var updateNIS = edtNisEdit.text

        presenter = PresenterCRUD(this)

        btnDelete.setOnClickListener {
            presenter!!.Hapus(id.toString())
        }

        btnUpdate.setOnClickListener {
            presenter!!.Update(id.toString(), updateNama.toString(),updateNIS.toString())
        }



    }

    override fun Hasil(result: String, msg: String) {
        if(result.equals("true")){
            startActivity(Intent(applicationContext,MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(applicationContext,msg,Toast.LENGTH_LONG).show()
        }
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun Error(error: String) {
        Log.d("Error Delete : ",error.toString())
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
