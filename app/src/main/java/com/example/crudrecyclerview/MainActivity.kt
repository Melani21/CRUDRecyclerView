package com.example.crudrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var inputNis:EditText
    private lateinit var inputNama:EditText
    private lateinit var jklakilaki:RadioButton
    private lateinit var jkPerempuan:RadioButton
    private lateinit var btnTambah:Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager:RecyclerView.LayoutManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inputNis = findViewById(R.id.txtinputNis)
        inputNama = findViewById(R.id.txtinputNama)
        jklakilaki= findViewById(R.id.rbLakiLaki)
        jkPerempuan= findViewById(R.id.rbPerempuan)
        btnTambah = findViewById(R.id.btnTambah)
        recyclerView =findViewById(R.id.listDataSiswa)
        //membuat variabel kososng tipe arrty Mutablist untuk simpnsn data arry
        //data arry disimpan diatas calss SiswaData
        val data= mutableListOf<SiswaData>()
        viewManager=LinearLayoutManager(this)
        recyclerAdapter=SiswaAdapter(data)
        recyclerView.adapter=recyclerAdapter
        recyclerView.layoutManager=viewManager
        //setlistktener unuk tombol Tambah Data
        btnTambah.setOnClickListener {
            //1.membuat variabel penyimpan data
            val nis = inputNis.text.toString()
            val nama = inputNama.text.toString()
            var jk =""
            if(jklakilaki.isChecked){
                jk ="Laki-laki"
            }else {
                jk ="Perempuan"
            }
            //simpan data ke arry mutablelist
            val dataSiswa =SiswaData(nis,nama,jk)
            data.add(dataSiswa)
            recyclerAdapter.notifyDataSetChanged()
        }
    }
}