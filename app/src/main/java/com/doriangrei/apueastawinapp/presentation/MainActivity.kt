package com.doriangrei.apueastawinapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.doriangrei.apueastawinapp.controller.LevelsSettings
import com.doriangrei.apueastawinapp.presentation.contract.Navigator
import com.doriangrei.apueastawinapp.databinding.ActivityMainBinding
import com.doriangrei.apueastawinapp.model.Level
import com.doriangrei.apueastawinapp.presentation.screens.GameFragment
import com.doriangrei.apueastawinapp.presentation.screens.LevelFragment
import com.doriangrei.apueastawinapp.presentation.screens.ResultFragment
import com.doriangrei.apueastawinapp.presentation.screens.StartFragment
import com.doriangrei.apueastawinapp.presentation.util.FragmentManager
import com.doriangrei.apueastawinapp.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        if (savedInstanceState == null) {
            goToMainScreen()
        }
    }

    override fun goToMainScreen() {
        FragmentManager.launchFragment(this, StartFragment.newInstance())
    }

    override fun goToGameScreen(level: Level) {
        FragmentManager.launchFragment(this, GameFragment.newInstance(level))
    }

    override fun goToScoreScreen(isWin: Boolean, level: Level) {
        FragmentManager.launchFragment(this, ResultFragment.newInstance(isWin, level))
    }

    override fun goToChooseDifficult(levels: ArrayList<Level>) {
        FragmentManager.launchFragment(this, LevelFragment.newInstance(levels))
    }
}