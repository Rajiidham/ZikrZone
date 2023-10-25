package com.example.mydzikiryukapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class ArtikelModel(
    val imageArtikel: Int,
    val titleArtikel: String,
    val descArtikel: String

) : Parcelable