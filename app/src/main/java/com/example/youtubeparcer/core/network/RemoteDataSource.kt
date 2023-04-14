package com.example.youtubeparcer.core.network

import com.bumptech.glide.load.DataSource
import com.example.youtubeparcer.BuildConfig
import com.example.youtubeparcer.core.network.result.Resource
import com.example.youtubeparcer.data.remote.ApiService
import com.example.youtubeparcer.data.remote.model.PlayList
import com.example.youtubeparcer.utils.Const

class RemoteDataSource: BaseDataSource() {
    val apiService: ApiService = RetrofitClient.create()
    suspend fun getPlayList(): Resource<PlayList> {
        return getResult {
           apiService.getPLayLists(BuildConfig.API_KEY, Const.part, Const.channelId)
        }
    }
}