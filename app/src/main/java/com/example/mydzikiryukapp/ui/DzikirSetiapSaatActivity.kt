package com.example.mydzikiryukapp.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydzikiryukapp.adapter.DzikirDoaAdapter
import com.example.mydzikiryukapp.databinding.ActivityDzikirSetiapSaatBinding
import com.example.mydzikiryukapp.model.DataDzikirDoaModel

class DzikirSetiapSaatActivity : AppCompatActivity() {

    lateinit var binding: ActivityDzikirSetiapSaatBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirSetiapSaatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Setiap Saat"

        binding.apply {
            rvDzikirSetiapSaat.layoutManager = LinearLayoutManager(this@DzikirSetiapSaatActivity)
            rvDzikirSetiapSaat.adapter = DzikirDoaAdapter(DataDzikirDoaModel.listDzikir)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

}