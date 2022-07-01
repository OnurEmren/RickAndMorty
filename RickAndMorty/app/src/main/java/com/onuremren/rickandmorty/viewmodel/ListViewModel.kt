package com.onuremren.rickandmorty.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.onuremren.rickandmorty.model.Character
import com.onuremren.rickandmorty.repo.Repository
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.*

class ListViewModel (private val repository: Repository): ViewModel() {

    // Alacağımız verileri burada bir liste şeklinde belirtiyoruz. Bu verileri Mutable yani değiştirilebilir,
    // ve livedata yani lifecycle ile uyumlu çalışan bir şekilde oluşturuyoruz.
    var job: Job?= null
    val rickList = MutableLiveData<List<Character>>()

    // Bu fonksiyon ile verilerimizi alıyoruz. Repositorydeki fonksiyonumuzu da çağırıyoruz.
    // Bu işlemleri coroutine içerisinde yaparak asenkron bir işlem yapmış oluyoruz.

    /*
    fun getCharacters(rick: Int){
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = repository.getCharactersFromApi(rick)
            withContext(Dispatchers.Main){
                if (response)
            }
        }

    }

     */


     fun getCharacters(page: Int){
        viewModelScope.launch {
            val characters = repository.getCharactersFromApi(page)
            //Oluşturduğumuz listeyi value yöntemi ile çağırıp(viewmodel içerisinde olduğumuz için)
            // verilerin geleceği model ile bağlıyoruz.
            rickList.value = characters.results
        }
    }


}