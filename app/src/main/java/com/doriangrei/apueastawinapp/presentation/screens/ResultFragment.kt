package com.doriangrei.apueastawinapp.presentation.screens

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
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
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

                        val listLevels = viewModel.levelsData.value!!
                        val newListLevel = ArrayList<Level>(listLevels)
                        listLevels.forEachIndexed { index, listLevel ->
                            if (level.levelName == listLevel.levelName) {
                                if (index < listLevels.size) {
                                    val unlockedLevel = listLevels[index + 1].copy(isLock = false)
                                    newListLevel.removeAt(index + 1)
                                    newListLevel.add(index + 1, unlockedLevel)
                                }
                            }
                        }
                        viewModel.saveProgress(newListLevel)

                        btnActionAfterGame.setOnClickListener {
                            navigator()?.goToChooseDifficult(newListLevel)
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