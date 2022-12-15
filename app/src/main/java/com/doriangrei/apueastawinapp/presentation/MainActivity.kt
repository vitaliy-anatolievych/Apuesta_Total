package com.doriangrei.apueastawinapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.doriangrei.apueastawinapp.presentation.contract.Navigator
import com.doriangrei.apueastawinapp.databinding.ActivityMainBinding
import com.doriangrei.apueastawinapp.model.Level
import com.doriangrei.apueastawinapp.presentation.screens.GameFragment
import com.doriangrei.apueastawinapp.presentation.screens.LevelFragment
import com.doriangrei.apueastawinapp.presentation.screens.ResultFragment
import com.doriangrei.apueastawinapp.presentation.screens.StartFragment
import com.doriangrei.apueastawinapp.presentation.util.FragmentManager

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            goToChooseDifficult()
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
        val listLevels = ArrayList<Level>()
        listLevels.add(Level(1, 24,24,2,false))
        listLevels.add(Level(2, 24,24,2,true))
        listLevels.add(Level(3, 24,24,2,true))
        listLevels.add(Level(4, 24,24,2,true))
        listLevels.add(Level(5, 24,24,2,true))
        listLevels.add(Level(6, 24,24,2,true))
        FragmentManager.launchFragment(this, LevelFragment.newInstance(listLevels))
    }
}