package com.dino.sfoide.ui.detail

import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf
import com.dino.library.ui.DinoActivity
import com.dino.sfoide.R
import com.dino.sfoide.databinding.ActivityUserDetailBinding
import com.dino.sfoide.model.UserInfoModel
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserDetailActivity :
    DinoActivity<ActivityUserDetailBinding, UserDetailViewModel>(R.layout.activity_user_detail) {

    override val viewModel by viewModel<UserDetailViewModel> {
        parametersOf(intent.getParcelableExtra(EXTRA_USER_INFO))
    }

    companion object {
        private const val EXTRA_USER_INFO = "EXTRA_USER_INFO"

        fun startActivity(context: Context, userInfo: UserInfoModel){
            context.startActivity(Intent(context, UserDetailActivity::class.java).apply {
                putExtras(bundleOf(
                    EXTRA_USER_INFO to userInfo
                ))
            })

        }

    }

}