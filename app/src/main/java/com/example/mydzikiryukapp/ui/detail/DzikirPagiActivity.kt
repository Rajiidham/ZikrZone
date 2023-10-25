package com.example.mydzikiryukapp.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydzikiryukapp.R
import com.example.mydzikiryukapp.adapter.DzikirDoaAdapter
import com.example.mydzikiryukapp.databinding.ActivityDzikirPagiBinding
import com.example.mydzikiryukapp.model.DataDzikirDoaModel

class DzikirPagiActivity : AppCompatActivity() {

    lateinit var binding: ActivityDzikirPagiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPagiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir - Dzikir Pagi"

        binding.apply {
            rvDzikirPagi.layoutManager = LinearLayoutManager(this@DzikirPagiActivity)
            rvDzikirPagi.adapter = DzikirDoaAdapter(DataDzikirDoaModel.listDzikirPagi)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

}