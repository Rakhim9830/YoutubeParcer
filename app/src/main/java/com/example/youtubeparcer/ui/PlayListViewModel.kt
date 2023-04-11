package com.example.youtubeparcer.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.youtubeparcer.App
import com.example.youtubeparcer.BuildConfig
import com.example.youtubeparcer.base.BaseViewModel
import com.example.youtubeparcer.data.remote.model.PlayList
import com.example.youtubeparcer.data.remote.ApiService
import com.example.youtubeparcer.core.network.RetrofitClient
import com.example.youtubeparcer.core.network.result.Resource
import com.example.youtubeparcer.repository.Repository
import retrofit2.*

class PlayListViewModel:BaseViewModel() {
    fun playList():LiveData<Resource<PlayList>>{
        return App.repository.getPlayList()
    }
}