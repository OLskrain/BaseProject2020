package com.olskrain.baseproject2020.app.ui.navigation

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.olskrain.baseproject2020.R
import com.olskrain.baseproject2020.component.navigation.*

/**
 * Created by Andrey Ievlev on 09,Март,2020
 */

class NavigatorImpl(
    private val activity: AppCompatActivity,
    @IdRes private val contentLayoutId: Int = R.id.content_frame
) : Navigator {

    private val fragmentManager = activity.supportFragmentManager

    override fun goto(destination: Destination) {
        when (destination) {
            is Back -> back()
            is BackTo -> backTo(destination.destination)
            else -> next(destination)
        }
    }

    private fun next(destination: Destination) {
        val fragment = createFragment(destination)

        fragment?.let {
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction
                .replace(contentLayoutId, fragment, destination::class.java.name)
                .addToBackStack(destination::class.java.name)
                .commit()
        }
            ?: throw IllegalArgumentException("unknown destination: ${destination.javaClass.simpleName}")
    }

    private fun back() {
        if (fragmentManager.backStackEntryCount > 1) {
            fragmentManager.popBackStackImmediate()
        } else {
            exit()
        }
    }

    private fun backTo(destination: Class<out Destination>) {
        for (i in fragmentManager.backStackEntryCount - 1 downTo 0) {
            if (destination.name == fragmentManager.getBackStackEntryAt(i).name) {
                fragmentManager.popBackStackImmediate(destination.name, 0)
                return
            }
        }

        backToRoot()
    }

    private fun backToRoot() {
        if (fragmentManager.backStackEntryCount > 0) {
            fragmentManager.popBackStackImmediate(fragmentManager.getBackStackEntryAt(0).name, 0)
        }
    }

    private fun createFragment(destination: Destination): Fragment? =
        when (destination) {
            is FragmentDestination -> destination.getFragment()
            else -> null
        }

    private fun exit() {
        activity.finish()
    }
}