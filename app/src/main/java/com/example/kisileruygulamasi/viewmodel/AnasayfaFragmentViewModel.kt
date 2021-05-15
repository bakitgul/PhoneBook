package com.example.kisileruygulamasi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kisileruygulamasi.entity.Kisiler
import com.example.kisileruygulamasi.repo.KisilerdaoRepository

class AnasayfaFragmentViewModel:ViewModel() {

    var kisilerListesi = MutableLiveData<List<Kisiler>>()
    val kdaor = KisilerdaoRepository()

    init {
        kisilerYukle()
        kisilerListesi = kdaor.kisileriGetir()
    }

    fun kisilerYukle(){
        kdaor.tumKisileriAl()

        /*val liste = ArrayList<Kisiler>()
        liste.add(Kisiler(1,"Ihsan","111111"))
        liste.add(Kisiler(2,"Bakit","222222"))

        kisilerListesi.value = liste*/
    }

    fun ara(aramaKelimesi:String) {
        kdaor.kisiAra(aramaKelimesi)
    }

    fun sil(kisi_id:Int){
        kdaor.kisiSil(kisi_id)
        //Log.e("Kişi Sil","$kisi_id")
    }


}