package com.example.youtubeparcer.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeparcer.R
import com.example.youtubeparcer.base.BaseActivity
import com.example.youtubeparcer.databinding.ActivityVideosBinding

class VideosActivity : BaseActivity<ActivityVideosBinding, PlayListViewModel>() {

    override fun inflateViewBinding(): ActivityVideosBinding {
        return ActivityVideosBinding.inflate(layoutInflater)
    }

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }


    override fun initListener() {
        super.initListener()
        val resultIntent = intent.getStringExtra("id")
        Toast.makeText(this, resultIntent, Toast.LENGTH_SHORT).show()
    }
}

