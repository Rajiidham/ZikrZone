package com.example.mydzikiryukapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.viewpager2.widget.ViewPager2
import com.example.mydzikiryukapp.adapter.ArtikelAdapter
import com.example.mydzikiryukapp.databinding.ActivityMainBinding
import com.example.mydzikiryukapp.model.ArtikelModel
import com.example.mydzikiryukapp.ui.DzikirPagidanPetangActivity
import com.example.mydzikiryukapp.ui.DzikirSetiapSaatActivity
import com.example.mydzikiryukapp.ui.DzikirdanDoaHarianActivity
import com.example.mydzikiryukapp.ui.ProfilActivity
import com.example.mydzikiryukapp.ui.SunnahQouliyahActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var slideIndicator : Array<ImageView?>
    private val  listArtikel: ArrayList<ArtikelModel> = arrayListOf()

    private val slidingCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            for (i in 0 until listArtikel.size) {
                slideIndicator[i]?.setImageDrawable(
                    ContextCompat.getDrawable(applicationContext, R.drawable.dot_inactive)
                )
            }

            slideIndicator[position]?.setImageDrawable(
                ContextCompat.getDrawable(applicationContext, R.drawable.dot_active)
            )
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDataArtikel()
        setView()
        setUpViewPagerArtikel()

    }

    private fun  setView() {
        //setup view artikel
        binding.apply {
            vpArtikel.adapter = ArtikelAdapter(listArtikel)
            vpArtikel.registerOnPageChangeCallback(slidingCallback)

            llDzikirDoaShalat.setOnClickListener(this@MainActivity)
            llDzikirSetiapSaat.setOnClickListener(this@MainActivity)
            llDzikirPagiPetang.setOnClickListener(this@MainActivity)
            llDzikirDoaHarian.setOnClickListener(this@MainActivity)
            llProfil.setOnClickListener(this@MainActivity)
        }
    }

    private  fun setDataArtikel() {
        // bagian artikel
        val titleArtikel = resources.getStringArray(R.array.arr_title_artikel)
        val descArtikel = resources.getStringArray(R.array.arr_desc_artikel)
        val imgArtikel = resources.obtainTypedArray(R.array.arr_img_artikel)


        for (data in titleArtikel.indices) {
            val artikel = ArtikelModel(
                imgArtikel.getResourceId(data, 0),
                titleArtikel[data],
                descArtikel[data]
            )
            listArtikel.add(artikel)
        }
        imgArtikel.recycle()

    }

    private fun setUpViewPagerArtikel() {
        val llSliderDots = binding.llSliderDots

        slideIndicator = arrayOfNulls(listArtikel.size)

        for (i in 0 until listArtikel.size) {
            slideIndicator[i] = ImageView(this)
            slideIndicator[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext, R.drawable.dot_inactive
                )
            )


            // menentukan lebar dan tinggi indicator
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            // mengatur jarak antar indicator
            params.setMargins(9, 0, 8, 0)
            // mengatur posisi indicator
            params.gravity = Gravity.CENTER_VERTICAL
            // menerapkan params sebagai aturan bagaimana indicator ditampilkan
            llSliderDots.addView(slideIndicator[i], params)
        }

        slideIndicator[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext, R.drawable.dot_inactive
            )
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        binding.vpArtikel.unregisterOnPageChangeCallback(slidingCallback)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.ll_dzikir_doa_shalat -> {
                val intentDOS = Intent(this@MainActivity, SunnahQouliyahActivity::class.java)
                startActivity(intentDOS)
            }
            R.id.ll_dzikir_setiap_saat -> {
                val intentDOS = Intent(this@MainActivity, DzikirSetiapSaatActivity::class.java)
                startActivity(intentDOS)
            }
            R.id.ll_dzikir_pagi_petang -> {
                val intentDOS = Intent(this@MainActivity, DzikirPagidanPetangActivity::class.java)
                startActivity(intentDOS)
            }
            R.id.ll_dzikir_doa_harian -> {
                val intentDOS = Intent(this@MainActivity, DzikirdanDoaHarianActivity::class.java)
                startActivity(intentDOS)
            }
            R.id.ll_profil-> {
                val intentDOS = Intent(this@MainActivity, ProfilActivity::class.java)
                startActivity(intentDOS)
            }
        }
    }

}