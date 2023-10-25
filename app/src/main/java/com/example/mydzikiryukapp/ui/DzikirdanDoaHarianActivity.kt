package com.example.mydzikiryukapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydzikiryukapp.R
import com.example.mydzikiryukapp.adapter.DzikirDoaAdapter
import com.example.mydzikiryukapp.databinding.ActivityDzikirDanDoaHarianBinding
import com.example.mydzikiryukapp.model.DzikirDoaModel

class DzikirdanDoaHarianActivity : AppCompatActivity() {

    lateinit var binding: ActivityDzikirDanDoaHarianBinding
    private val doaharian: ArrayList<DzikirDoaModel> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirDanDoaHarianBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir & Doa Harian"

        binding.apply {
            rvDzikirDoaHarian.layoutManager =LinearLayoutManager(this@DzikirdanDoaHarianActivity)
            rvDzikirDoaHarian.adapter = DzikirDoaAdapter(doaharian)
        }

        setDataDzikirDoaHarian()

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    private fun setDataDzikirDoaHarian(): ArrayList<DzikirDoaModel> {
        val dzikir = resources.getStringArray(R.array.arr_dzikir_doa_harian)
        val lafaz = resources.getStringArray(R.array.arr_lafaz_dzikir_doa_harian)
        val terjemah = resources.getStringArray(R.array.arr_terjemah_dzikir_doa_harian)

        val minLength = minOf(dzikir.size, lafaz.size, terjemah.size)

        for (data in 0 until minLength) {
            val doa = DzikirDoaModel(
                dzikir[data],
                lafaz[data],
                terjemah[data]
            )
            doaharian.add(doa)
        }
        return doaharian
    }
}