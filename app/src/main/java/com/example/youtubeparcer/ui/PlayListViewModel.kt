package com.example.youtubeparcer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import com.example.youtubeparcer.BuildConfig
import com.example.youtubeparcer.adapter.PlayListsAdapter
import com.example.youtubeparcer.base.BaseViewModel
import com.example.youtubeparcer.model.PlayList
import com.example.youtubeparcer.remote.ApiService
import com.example.youtubeparcer.remote.RetrofitClient
import retrofit2.*

class PlayListViewModel:BaseViewModel() {
    private val apiService:ApiService = RetrofitClient.create()


    fun playList():LiveData<PlayList>{
        return getPlayList()
    }

    private fun getPlayList(): LiveData<PlayList> {
        val data = MutableLiveData<PlayList>()
        apiService.getPLayLists(BuildConfig.API_KEY, "contentDetails,snippet", "UCWOA1ZGywLbqmigxE4Qlvuw").enqueue(object :Callback<PlayList>{
            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                if (response.isSuccessful){
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<PlayList>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
        return data
    }
}