package com.onuremren.rickandmorty.service


import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object CharacterService {

    // retrofiti kuruyoruz. BaseUrl i bu noktada veriyoruz. coroutine içerisinde kullanacağız.
    // Bu şekilde asenkron işlem yapmış olacağız ve kullanıcının arayürüzünü kilitlemeyeceğiz.
    // Interface kısmında suspend kullanmamızla aynı sebepten dolayı.
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
    // Bir api değişkeni oluşturuyoruz.
    //Daha sonra oluşturduğumuz retrofiti alıp create metodu ile oluşturmuş oluyoruz.

    val api:CharacterInterface by lazy {
        retrofit.create(CharacterInterface::class.java)
    }
}