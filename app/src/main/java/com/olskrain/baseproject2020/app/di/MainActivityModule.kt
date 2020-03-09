package com.olskrain.baseproject2020.app.di

import com.olskrain.baseproject2020.app.ui.MainActivity
import com.olskrain.baseproject2020.app.ui.navigation.NavigatorImpl
import com.olskrain.baseproject2020.component.navigation.Navigator
import dagger.Module
import dagger.Provides

/**
 * Created by Andrey Ievlev on 09,Март,2020
 */

//подключаем все модули фрагментов и нафигацию к ним
//тут у нас abstract class так как используем статику
@Module
abstract class MainActivityModule {

    @Module
    companion object {

        @Provides
        @JvmStatic
        fun provideRouter(activity: MainActivity): Navigator =
            NavigatorImpl(activity)
    }
}