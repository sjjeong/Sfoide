package com.dino.sfoide.ui

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.dino.library.ui.DinoActivity
import com.dino.library.util.EndlessRecyclerViewScrollListener
import com.dino.sfoide.R
import com.dino.sfoide.databinding.ActivityMainBinding
import com.dino.sfoide.ui.detail.UserDetailActivity
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.subjects.BehaviorSubject

class MainActivity : DinoActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    private val endlessRecyclerViewScrollListener by lazy {
        object : EndlessRecyclerViewScrollListener(binding.rvContent.layoutManager!!) {
            override fun onLoadMore(page: Int, totalItemsCount: Int, view: RecyclerView) {
                viewModel.load()
            }
        }
    }

    private val backPressSubject = BehaviorSubject.createDefault(0L)

    private val compositeDisposable = CompositeDisposable()

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
        backPressSubject.buffer(2, 1)
            .subscribe {
                if (it[1] - it[0] < 2000L) {
                    finishAffinity()
                } else {
                    Toast.makeText(this@MainActivity, "앱을 종료하시려면 한번 더 눌러주세요.", Toast.LENGTH_SHORT)
                        .show()
                }
            }.addTo(compositeDisposable)
    }

    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    override fun onBackPressed() {
        if (viewModel.page == 1) {
            backPressSubject.onNext(System.currentTimeMillis())
        } else {
            binding.rvContent.smoothScrollToPosition(0)
            viewModel.refresh()
        }
    }

}
