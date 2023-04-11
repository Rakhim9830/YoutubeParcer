package com.example.youtubeparcer.ui.details

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeparcer.base.BaseActivity
import com.example.youtubeparcer.databinding.ActivityVideosBinding
import com.example.youtubeparcer.ui.PlayListViewModel

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

