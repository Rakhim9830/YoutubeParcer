package com.example.youtubeparcer.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity <VB: ViewBinding, VM:BaseViewModel>: AppCompatActivity(){
    protected lateinit var binding:VB
    protected abstract fun inflateViewBinding():VB
    protected abstract val viewModel:VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateViewBinding()
        setContentView(binding.root)

        isConnection()
        initViews()
        initViewModel()
        initListener()
        initRecycleView()
    }

    open fun initListener(){}

    open fun initViewModel(){}

    open fun isConnection(){}

    open fun initViews(){}

    open fun initRecycleView(){}
}