package com.olskrain.baseproject2020.app.di

import com.olskrain.baseproject2020.app.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * Created by Andrey Ievlev on 09,Март,2020
 */

@Module(includes = [AndroidSupportInjectionModule::class])
interface AppModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    @ActivityScope
    fun provideMainActivity(): MainActivity
}