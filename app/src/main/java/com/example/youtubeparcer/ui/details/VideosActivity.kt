package com.example.youtubeparcer.ui.details

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeparcer.base.BaseActivity
import com.example.youtubeparcer.core.network.connection.Connection
import com.example.youtubeparcer.databinding.ActivityVideosBinding
import com.example.youtubeparcer.ui.PlayListViewModel

class VideosActivity : BaseActivity<ActivityVideosBinding, PlayListViewModel>() {



    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
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
    override fun initListener() {
        super.initListener()
        val resultIntent = intent.getStringExtra("id")
        Toast.makeText(this, resultIntent, Toast.LENGTH_SHORT).show()
    }
    override fun inflateViewBinding(): ActivityVideosBinding {
        return ActivityVideosBinding.inflate(layoutInflater)
    }
}

