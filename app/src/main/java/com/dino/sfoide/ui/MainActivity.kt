package com.dino.sfoide.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.dino.library.ui.DinoActivity
import com.dino.library.util.EndlessRecyclerViewScrollListener
import com.dino.sfoide.R
import com.dino.sfoide.databinding.ActivityMainBinding
import com.dino.sfoide.ui.detail.UserDetailActivity

class MainActivity : DinoActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    private val endlessRecyclerViewScrollListener by lazy {
        object : EndlessRecyclerViewScrollListener(binding.rvContent.layoutManager!!) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                viewModel.load()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel {
            showUserDetail.observe(this@MainActivity, Observer { event ->
                event.get { userInfo ->
                    UserDetailActivity.startActivity(this@MainActivity, userInfo)
                }
            })
            refreshEvent.observe(this@MainActivity, Observer {
                endlessRecyclerViewScrollListener.resetState()
            })
        }
        binding {
            rvContent.addOnScrollListener(endlessRecyclerViewScrollListener)
        }
    }

}
