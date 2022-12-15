package com.doriangrei.apueastawinapp.presentation.screens

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.doriangrei.apueastawinapp.R
import com.doriangrei.apueastawinapp.presentation.contract.navigator
import com.doriangrei.apueastawinapp.databinding.FragmentResultBinding
import com.doriangrei.apueastawinapp.model.Level
import com.doriangrei.apueastawinapp.presentation.viewmodel.MainViewModel

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding: FragmentResultBinding
        get() = _binding ?: throw NullPointerException("FragmentResultBinding is null")

    private val viewModel by activityViewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root.also {
            val isWin = arguments?.getBoolean(IS_WIN)!!
            val level = arguments?.getParcelable<Level>(LEVEL)!!

            with(binding) {
                when (isWin) {
                    true -> {
                        resultLogo.setImageDrawable(getImageDrawable(R.drawable.logo_win))
                        btnActionAfterGame.setImageDrawable(getImageDrawable(R.drawable.btn_next))
                        val newLevelsList = viewModel.levelsData.value!!
                        viewModel.levelsData.value!!.forEachIndexed { index, arrLevel ->
                            if (arrLevel.levelName == level.levelName) {
                                if (index != newLevelsList.size) {
                                    val newLevel = newLevelsList.get(index + 1).copy(isLock = true)
                                    newLevelsList.add(index, newLevel)
                                }
                            }
                        }
                        viewModel.saveProgress(newLevelsList)
                        viewModel.getLevels()

                        btnActionAfterGame.setOnClickListener {
                            viewModel.levelsData.observe(viewLifecycleOwner) {
                                navigator()?.goToChooseDifficult(it!!)
                            }
                        }
                    }
                    false -> {
                        resultLogo.setImageDrawable(getImageDrawable(R.drawable.logo_loose))
                        btnActionAfterGame.setImageDrawable(getImageDrawable(R.drawable.btn_again))
                        btnActionAfterGame.setOnClickListener {
                            navigator()?.goToGameScreen(level)
                        }
                    }
                }
            }
        }
    }

    private fun getImageDrawable(@DrawableRes id: Int): Drawable? {
        return ResourcesCompat.getDrawable(resources, id, null)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {
        private const val IS_WIN = "is_win"
        private const val LEVEL = "level"

        @JvmStatic
        fun newInstance(isWin: Boolean, level: Level) = ResultFragment().apply {
            arguments = Bundle().apply {
                putBoolean(IS_WIN, isWin)
                putParcelable(LEVEL, level)
            }
        }
    }
}