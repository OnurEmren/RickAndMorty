package com.onuremren.rickandmorty.service


import com.onuremren.rickandmorty.model.CharacterList

import retrofit2.http.GET
import retrofit2.http.Query

//Get metodu ile api isteği atıyoruz.
// suspend fonk kullanılmasının sebebi ise ui ı kilitlemeden arka planda veri çekme işlemini yapmak istememiz.
//Query işlemi ise dışarıdan veri geleceğini ve bu verinin türünün ne olacağını anlatıyor.
// Daha sonra da bunu hangi classtan alacağımızı belirtiyoruz.

interface CharacterInterface {
    @GET("api/character")
    suspend fun getData(
        @Query("ricky") ricky : Int
    ): CharacterList
}