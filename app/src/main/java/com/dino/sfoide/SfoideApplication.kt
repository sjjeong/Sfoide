package com.dino.sfoide

import android.app.Application
import com.dino.library.di.getDinoNetworkModule
import com.dino.library.ext.setupKoin
import com.dino.sfoide.constant.Constant
import com.dino.sfoide.data.di.repositoryModule
import com.dino.sfoide.di.viewModelModule
import com.dino.sfoide.remote.di.remoteModule

class SfoideApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupKoin(
            this,
            getDinoNetworkModule(baseUrl = Constant.BASE_URL),
            viewModelModule,
            repositoryModule,
            remoteModule
        )
    }

}