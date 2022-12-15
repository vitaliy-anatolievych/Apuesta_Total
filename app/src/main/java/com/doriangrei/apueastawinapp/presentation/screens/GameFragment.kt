package com.doriangrei.apueastawinapp.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.doriangrei.apueastawinapp.databinding.FragmentGameBinding
import com.doriangrei.apueastawinapp.controller.GameManager
import com.doriangrei.apueastawinapp.model.Level
import kotlin.properties.Delegates

class GameFragment: Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw NullPointerException("FragmentGameBinding is null")

    private lateinit var level: Level

    private val numberRows = 9
    private val numberColumn = 9

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        level = arguments?.getParcelable(LEVEL)!!

        if (savedInstanceState == null) {
            activity?. let {
                GameManager.initGame(level, numberRows, numberColumn, binding, it)
            }
        }
        return binding.root
    }

    companion object {
        private const val LEVEL = "level"

        @JvmStatic
        fun newInstance(level: Level) = GameFragment().apply {
            arguments = Bundle().apply {
                this.putParcelable(LEVEL, level)
            }
        }
    }
}