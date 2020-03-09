package com.olskrain.baseproject2020.app.ui

import android.os.Bundle
import com.olskrain.baseproject2020.R
import com.olskrain.baseproject2020.component.navigation.Navigator
import com.olskrain.baseproject2020.component.ui.BaseFragment
import com.olskrain.baseproject2020.component.ui.extension.BaseActivity
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_activity)

        if (savedInstanceState == null) {
            //navigator.goto(LoginScreen)
        }
    }

    override fun onBackPressed() {
        val fragment = supportFragmentManager.findFragmentById(R.id.content_frame)
        if (fragment is BaseFragment && !fragment.onBackPressed()) {
            super.onBackPressed()
        }
    }
}