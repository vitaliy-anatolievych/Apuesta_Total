package com.doriangrei.apueastawinapp.util

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.doriangrei.apueastawinapp.R
import com.doriangrei.apueastawinapp.screens.StartFragment

object FragmentManager {

    private var _currentFragment: Fragment? = null
    val currentFragment: Fragment
        get() = _currentFragment ?: StartFragment.newInstance()

    fun launchFragment(activity: AppCompatActivity, fragment: Fragment) {
        _currentFragment = fragment
        activity.supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, fragment, fragment::class.simpleName)
            commit()
        }
    }
}