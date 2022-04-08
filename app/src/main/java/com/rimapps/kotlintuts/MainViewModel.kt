package com.rimapps.kotlintuts

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rimapps.kotlintuts.network.ApiClient
import com.rimapps.kotlintuts.network.Character
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception


class MainViewModel(private val repository:Repository
                    = Repository(ApiClient.apiService) ):ViewModel() {
    //modify values in need, but only within this class, thats why it private
    private var charactersLiveData = MutableLiveData<ScreenState<List<Character>?>>()
    val characterLiveData : LiveData<ScreenState<List<Character>?>>
        get() = charactersLiveData

    init{
        fetchCharacter()
    }
    private fun fetchCharacter() {
        charactersLiveData.postValue(ScreenState.Loading(null))
    /**
     * to run on main thread use
        viewModelScope.launch (){
        */
        //t run on different thread
        viewModelScope.launch (Dispatchers.IO){
            Log.d("CheckThread",Thread.currentThread().name)
            try {
                val client = repository.getCharacters("1")
                charactersLiveData.postValue(ScreenState.Success(client.result))
            }catch (e:Exception){
                charactersLiveData.postValue(ScreenState.Error(e.message.toString(),null))
            }

        }

    }
}
