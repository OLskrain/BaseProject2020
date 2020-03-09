package com.olskrain.baseproject2020.component.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

/**
 * Created by Andrey Ievlev on 10,Март,2020
 */

abstract class BaseFragment : DaggerFragment() {

    abstract val contentLayout: Int

    open fun onBackPressed(): Boolean = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? =
        inflater.inflate(contentLayout, container, false)
}