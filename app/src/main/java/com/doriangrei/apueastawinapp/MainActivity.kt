package com.doriangrei.apueastawinapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.doriangrei.apueastawinapp.contract.Navigator
import com.doriangrei.apueastawinapp.databinding.ActivityMainBinding
import com.doriangrei.apueastawinapp.screens.GameFragment
import com.doriangrei.apueastawinapp.screens.ResultFragment
import com.doriangrei.apueastawinapp.screens.StartFragment
import com.doriangrei.apueastawinapp.util.FragmentManager

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.main_container, GameFragment.newInstance(24), GameFragment::class.simpleName)
            commit()
        }
    }

    override fun goToMainScreen() {
        FragmentManager.launchFragment(this, StartFragment.newInstance())
    }

    override fun goToGameScreen(steps: Int) {
        FragmentManager.launchFragment(this, GameFragment.newInstance(steps))
    }

    override fun goToScoreScreen(isWin: Boolean) {
        FragmentManager.launchFragment(this, ResultFragment.newInstance(isWin))
    }

    override fun goToChooseDifficult() {
        TODO("Not yet implemented")
    }
}