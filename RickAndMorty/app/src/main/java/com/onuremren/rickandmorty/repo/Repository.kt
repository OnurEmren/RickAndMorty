package com.onuremren.rickandmorty.repo


import com.onuremren.rickandmorty.model.CharacterList
import com.onuremren.rickandmorty.service.CharacterService

class Repository {

    // Serviste kurduğumuz api ı burada çağırıyoruz ve artık internetten veri çekme işlemini tamamlıyoruz.
    // veriyi hangi modelden çekeceğimizi de burada belirtiyoruz.
    // suspend kullanmamız ui ı kilitlemememiz için önemli.

    suspend fun getCharactersFromApi(ricky: Int): CharacterList {
        return CharacterService.api.getData(ricky)

    }
}