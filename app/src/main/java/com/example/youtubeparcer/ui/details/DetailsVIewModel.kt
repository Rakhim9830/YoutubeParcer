package com.example.youtubeparcer.ui.details

import androidx.lifecycle.LiveData
import com.example.youtubeparcer.App
import com.example.youtubeparcer.base.BaseViewModel
import com.example.youtubeparcer.core.network.result.Resource
import com.example.youtubeparcer.data.remote.model.PlayList

class DetailsVIewModel:BaseViewModel() {
    fun itemList(id:String): LiveData<PlayList> {
        return App.repository.getListItem(id = id)
    }
}