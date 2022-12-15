package com.doriangrei.apueastawinapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.doriangrei.apueastawinapp.databinding.FragmentGameBinding
import com.doriangrei.apueastawinapp.managers.GameManager
import kotlin.properties.Delegates

class GameFragment: Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = _binding ?: throw NullPointerException("FragmentGameBinding is null")

    private var steps by Delegates.notNull<Int>()

    private val numberRows = 9
    private val numberColumn = 9

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        steps = arguments?.getInt(STEPS, 0)!!
        if (savedInstanceState == null) {
            activity?. let {
                GameManager.initGame(steps, numberRows, numberColumn, binding, it)
            }
        }
        return binding.root
    }

    companion object {
        private const val STEPS = "steps"

        @JvmStatic
        fun newInstance(steps: Int) = GameFragment().apply {
            arguments = Bundle().apply {
                this.putInt(STEPS, steps)
            }
        }
    }
}