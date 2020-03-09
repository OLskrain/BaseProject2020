package com.olskrain.baseproject2020.app

import com.olskrain.baseproject2020.app.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

/**
 * Created by Andrey Ievlev on 09,Март,2020
 */

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent
            .factory()
            .create(instance = this, context = this, contentResolver = contentResolver)
}