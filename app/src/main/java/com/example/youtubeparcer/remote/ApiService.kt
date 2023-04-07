package com.example.youtubeparcer.remote

import com.example.youtubeparcer.model.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("playlists")
    fun getPLayLists(
        @Query("key")key :String,
        @Query("part") part:String,
        @Query("channelId") channelId:String,

    ):Call<PlayList>
}