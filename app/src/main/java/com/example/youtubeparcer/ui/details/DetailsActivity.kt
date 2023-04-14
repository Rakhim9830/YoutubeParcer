package com.example.youtubeparcer.ui.details

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeparcer.base.BaseActivity
import com.example.youtubeparcer.core.network.connection.Connection
import com.example.youtubeparcer.databinding.ActivityVideosBinding
import com.example.youtubeparcer.ui.PlayListViewModel

class DetailsActivity : BaseActivity<ActivityVideosBinding, DetailsVIewModel>() {
   private lateinit var adapter: DetailsAdapter

   private val id:String?
   get() = intent.getStringExtra(ID)

    override val viewModel: DetailsVIewModel by lazy {
        ViewModelProvider(this)[DetailsVIewModel::class.java]
    }
    override fun isConnection() {
        super.isConnection()
        val connection = Connection(application)
        connection.observe(this){isConnected->
            if (isConnected){

                binding.noInet.visibility = View.GONE
            }
            else{
                binding.noInet.visibility = View.VISIBLE
            }
        }

    }

    override fun initViewModel() {
        super.initViewModel()
        setItemList()
    }
    private fun setItemList(){
        id?.let { id->
            viewModel.itemList(id).observe(this){
                binding.videosRv.layoutManager = LinearLayoutManager(this)
                adapter = DetailsAdapter()
                binding.videosRv.adapter = adapter
                adapter.setList(it.items)
            }
        }
    }

    override fun initListener() {
        super.initListener()
        binding.btnBack.setOnClickListener {
            finish()
        }
    }

    override fun inflateViewBinding(): ActivityVideosBinding {
        return ActivityVideosBinding.inflate(layoutInflater)
    }
    companion object{
        const val ID = "id"
    }
}

