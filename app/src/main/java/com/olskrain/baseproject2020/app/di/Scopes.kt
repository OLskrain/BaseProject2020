package com.olskrain.baseproject2020.app.di

import javax.inject.Scope

/**
 * Created by Andrey Ievlev on 09,Март,2020
 */

//тут наши scope для различных слоев
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class AppScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class NestedFragmentScope