package com.example.mydzikiryukapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mydzikiryukapp.R
import com.example.mydzikiryukapp.adapter.DzikirDoaAdapter
import com.example.mydzikiryukapp.databinding.ActivityDzikirPagiBinding
import com.example.mydzikiryukapp.databinding.ActivityDzikirPagiDanPetangBinding
import com.example.mydzikiryukapp.databinding.ActivityDzikirPetangBinding
import com.example.mydzikiryukapp.databinding.ActivityDzikirSetiapSaatBinding
import com.example.mydzikiryukapp.model.DataDzikirDoaModel
import com.example.mydzikiryukapp.ui.detail.DzikirPagiActivity
import com.example.mydzikiryukapp.ui.detail.DzikirPetangActivity

class DzikirPagidanPetangActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDzikirPagiDanPetangBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirPagiDanPetangBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Dzikir Pagi & Petang"

        binding.apply {
            imgBtnDzikirPagi.setOnClickListener(this@DzikirPagidanPetangActivity)
            imgBtnDzikirPetang.setOnClickListener(this@DzikirPagidanPetangActivity)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

    override fun onClick(v: View?) {
        when(v?. id) {
            R.id.img_btn_dzikir_pagi -> {
                val intentDDS = Intent(this@DzikirPagidanPetangActivity, DzikirPagiActivity::class.java)
                startActivity(intentDDS)
            }

            R.id.img_btn_dzikir_petang -> {
                val intentDDS = Intent(this@DzikirPagidanPetangActivity, DzikirPetangActivity::class.java)
                startActivity(intentDDS)
            }
        }
    }

}