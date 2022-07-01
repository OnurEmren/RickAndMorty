package com.onuremren.rickandmorty.model

import android.os.Parcelable
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//(parcelize) veri gönderirken kullanılan bir yöntem olarak geçiyor. Daha fazla bilgi edinemedim.
@Parcelize
//Data class veri çekeceğimiz durumlarda kullanılması uygun olan bir sınıf türüdür.
//Bu veri türünde mutlaka val veya var şeklinde veri tanımlanmalıdır.

data class Character (
    //SerializedName Gson'daki verilerle modelimizdeki verilerin eşleşmesini sağlıyor.
    //isim-value -> aynı olmalı.

    @PrimaryKey(autoGenerate = true)
    var id : Int,
    @SerializedName("name")
    var name: String,
    @SerializedName("status")
    var status : String,
    @SerializedName("species")
    var species: String,
    @SerializedName("gender")
    var gender: String,
    @SerializedName("origin")
    var origin : LocationData,
    @SerializedName("location")
    var location : LocationData,
    @SerializedName("image")
    var image : String,
    @SerializedName("episode")
    var episode : List<String>
): Parcelable