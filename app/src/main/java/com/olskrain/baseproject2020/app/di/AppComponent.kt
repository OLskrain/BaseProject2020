package com.olskrain.baseproject2020.app.di

import android.content.ContentResolver
import android.content.Context
import com.olskrain.baseproject2020.app.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

/**
 * Created by Andrey Ievlev on 09,Март,2020
 */

@Component(modules = [AppModule::class])
@AppScope
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance instance: App,
                   @BindsInstance context: Context,
                   @BindsInstance contentResolver: ContentResolver): AndroidInjector<App>
    }
}