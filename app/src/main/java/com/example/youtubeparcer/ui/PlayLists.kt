package com.example.youtubeparcer.ui
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.youtubeparcer.BuildConfig
import com.example.youtubeparcer.R
import com.example.youtubeparcer.adapter.PlayListsAdapter
import com.example.youtubeparcer.base.BaseActivity
import com.example.youtubeparcer.base.BaseViewModel
import com.example.youtubeparcer.databinding.ActivityMainBinding
import com.example.youtubeparcer.databinding.PlaylistItemBinding
import com.example.youtubeparcer.model.Item
import com.example.youtubeparcer.model.PlayList
import com.example.youtubeparcer.remote.ApiService
import com.example.youtubeparcer.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.Collections.list

class PlayLists() : BaseActivity<ActivityMainBinding, BaseViewModel>() {
private lateinit var adapter:PlayListsAdapter

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }


    override fun initViewModel() {
        super.initViewModel()
         viewModel.playList().observe(this) {
           binding.rvPlaylist.adapter = adapter
           adapter.setList(it.items)
        }
    }

    override fun initRecycleView() {
        super.initRecycleView()
        adapter = PlayListsAdapter(this::onClick)
    }

    override fun inflateViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    fun onClick(item: Item){
        val intent = Intent(this@PlayLists, VideosActivity::class.java)
        intent.putExtra("id", item.snippet.title)
        Toast.makeText(this, item.snippet.title, Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }

}



