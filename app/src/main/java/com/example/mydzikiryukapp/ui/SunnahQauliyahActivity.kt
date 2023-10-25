package com.example.mydzikiryukapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydzikiryukapp.R
import com.example.mydzikiryukapp.adapter.DzikirDoaAdapter
import com.example.mydzikiryukapp.databinding.ActivityDetailArtikelBinding
import com.example.mydzikiryukapp.databinding.ActivitySunnahQauliyahBinding
import com.example.mydzikiryukapp.model.DataDzikirDoaModel

class SunnahQouliyahActivity : AppCompatActivity() {

    lateinit var binding: ActivitySunnahQauliyahBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySunnahQauliyahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Sunnah - Sunnah Qouliyah"

        binding.apply {
            rvQauliyahShalat.layoutManager = LinearLayoutManager(this@SunnahQouliyahActivity)
            rvQauliyahShalat.adapter = DzikirDoaAdapter(DataDzikirDoaModel.listQauliyah)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }
}