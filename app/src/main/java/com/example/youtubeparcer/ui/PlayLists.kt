package com.example.youtubeparcer.ui
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.youtubeparcer.base.BaseActivity
import com.example.youtubeparcer.core.network.connection.Connection
import com.example.youtubeparcer.core.network.result.Status
import com.example.youtubeparcer.databinding.ActivityMainBinding
import com.example.youtubeparcer.data.remote.model.Item
import com.example.youtubeparcer.data.remote.model.Localized
import com.example.youtubeparcer.ui.details.DetailsActivity

class PlayLists() : BaseActivity<ActivityMainBinding, PlayListViewModel>() {
private lateinit var adapter: PlayListsAdapter

    override val viewModel: PlayListViewModel by lazy {
        ViewModelProvider(this)[PlayListViewModel::class.java]
    }

    override fun isConnection() {
        super.isConnection()
        val connection = Connection(application)
        connection.observe(this){isConnected->
            if (isConnected){
                binding.rvPlaylist.visibility = View.VISIBLE
                binding.noInet.visibility = View.GONE
            }
            else{
                binding.rvPlaylist.visibility = View.GONE
                binding.noInet.visibility = View.VISIBLE
            }
            }

        }


    override fun initViewModel() {
        super.initViewModel()

        viewModel.loading.observe(this){

        }
         viewModel.playList().observe(this) {
           when(it.status){
               Status.SUCCESS->{
                   binding.rvPlaylist.adapter = adapter
                   adapter.setData(it.data!!.items)
                   viewModel.loading.postValue(false)
               }
               Status.LOADING -> {
                   viewModel.loading.postValue(true)
               }
               Status.ERROR -> {
                   Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                   viewModel.loading.postValue(false)
               }
           }

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
        val intent = Intent(this@PlayLists, DetailsActivity::class.java)
        intent.putExtra(ID, item.id)
        startActivity(intent)
    }
    companion object{
        const val ID = "id"
    }

}





