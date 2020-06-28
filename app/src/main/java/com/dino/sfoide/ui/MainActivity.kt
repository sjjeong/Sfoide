package com.dino.sfoide.ui

import android.os.Bundle
import androidx.lifecycle.Observer
import com.dino.library.ui.DinoActivity
import com.dino.sfoide.R
import com.dino.sfoide.databinding.ActivityMainBinding
import com.dino.sfoide.ui.detail.UserDetailActivity

class MainActivity : DinoActivity<ActivityMainBinding, MainViewModel>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel {
            showUserDetail.observe(this@MainActivity, Observer { event ->
                event.get { userInfo ->
                    UserDetailActivity.startActivity(this@MainActivity, userInfo)
                }
            })
        }
    }

}
