package com.doriangrei.apueastawinapp.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.doriangrei.apueastawinapp.R
import com.doriangrei.apueastawinapp.controller.LevelsSettings
import com.doriangrei.apueastawinapp.presentation.contract.navigator
import com.doriangrei.apueastawinapp.presentation.viewmodel.MainViewModel

class StartFragment: Fragment() {

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false).apply {
            this.findViewById<ImageButton>(R.id.btn_start).setOnClickListener {
                viewModel.getLevels()

                viewModel.levelsData.observe(viewLifecycleOwner) {
                    if (it != null) {
                        navigator()?.goToChooseDifficult(it)
                    } else {
                        val levels = LevelsSettings.getDefaultLevels()
                        navigator()?.goToChooseDifficult(levels)
                    }
                }
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = StartFragment()
    }
}