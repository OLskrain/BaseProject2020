package com.olskrain.baseproject2020.component.navigation

import androidx.fragment.app.Fragment

/**
 * Created by Andrey Ievlev on 09,Март,2020
 */

interface Destination

interface FragmentDestination : Destination {

    fun getFragment(): Fragment
}

object Back : Destination

data class BackTo(val destination: Class<out Destination>) : Destination