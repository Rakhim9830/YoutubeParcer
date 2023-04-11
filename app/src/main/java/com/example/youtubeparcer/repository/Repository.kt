package com.example.youtubeparcer.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeparcer.BuildConfig
import com.example.youtubeparcer.core.network.RetrofitClient
import com.example.youtubeparcer.core.network.result.Resource
import com.example.youtubeparcer.data.remote.ApiService
import com.example.youtubeparcer.data.remote.model.PlayList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

     fun getPlayList(): LiveData<Resource<PlayList>> {
        val apiService: ApiService = RetrofitClient.create()
        val data = MutableLiveData<Resource<PlayList>>()
        data.value = Resource.loading()

        apiService.getPLayLists(BuildConfig.API_KEY, "contentDetails,snippet", "UCWOA1ZGywLbqmigxE4Qlvuw").enqueue(object :
            Callback<PlayList> {
            override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                if (response.isSuccessful){
                    data.value = Resource.success(response.body())
                }
            }

            override fun onFailure(call: Call<PlayList>, t: Throwable) {
               data.value = Resource.error(t.message, null, 400)
            }

        })
        return data
    }
}