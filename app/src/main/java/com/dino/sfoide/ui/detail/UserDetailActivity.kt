package com.dino.sfoide.ui.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.core.os.bundleOf
import com.dino.library.ui.DinoActivity
import com.dino.sfoide.R
import com.dino.sfoide.databinding.ActivityUserDetailBinding
import com.dino.sfoide.model.UserInfoModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class UserDetailActivity :
    DinoActivity<ActivityUserDetailBinding, UserDetailViewModel>(R.layout.activity_user_detail),
    OnMapReadyCallback {

    override val viewModel by viewModel<UserDetailViewModel> {
        parametersOf(intent.getParcelableExtra(EXTRA_USER_INFO))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (supportFragmentManager.findFragmentById(R.id.map) as?
                SupportMapFragment)?.getMapAsync(this@UserDetailActivity)
    }

    override fun onMapReady(map: GoogleMap?) {
        map ?: return
        val location = LatLng(viewModel.userInfo.lat, viewModel.userInfo.lng)
        map.addMarker(MarkerOptions().position(location).title("Location"))
        map.moveCamera(CameraUpdateFactory.newLatLng(location))
    }

    companion object {
        private const val EXTRA_USER_INFO = "EXTRA_USER_INFO"

        fun startActivity(context: Context, userInfo: UserInfoModel) {
            context.startActivity(Intent(context, UserDetailActivity::class.java).apply {
                putExtras(
                    bundleOf(
                        EXTRA_USER_INFO to userInfo
                    )
                )
            })

        }

    }

}