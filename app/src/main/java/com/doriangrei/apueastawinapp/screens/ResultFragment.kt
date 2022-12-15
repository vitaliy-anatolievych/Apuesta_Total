package com.doriangrei.apueastawinapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.doriangrei.apueastawinapp.R

class ResultFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_result, container, false).apply {
            val isWin = arguments?.getBoolean(IS_WIN)!!
            // todo init result
        }
    }

    companion object {
        private const val IS_WIN = "is_win"

        @JvmStatic
        fun newInstance(isWin: Boolean) = ResultFragment().apply {
            arguments = Bundle().apply {
                putBoolean(IS_WIN, isWin)
            }
        }
    }
}