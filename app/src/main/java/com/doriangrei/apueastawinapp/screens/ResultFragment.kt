package com.doriangrei.apueastawinapp.screens

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.doriangrei.apueastawinapp.R
import com.doriangrei.apueastawinapp.contract.navigator
import com.doriangrei.apueastawinapp.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding: FragmentResultBinding
        get() = _binding ?: throw NullPointerException("FragmentResultBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root.also {
            val isWin = arguments?.getBoolean(IS_WIN)!!
            with(binding) {
                when (isWin) {
                    true -> {
                        resultLogo.setImageDrawable(getImageDrawable(R.drawable.logo_win))
                        btnActionAfterGame.setImageDrawable(getImageDrawable(R.drawable.btn_next))
                        btnActionAfterGame.setOnClickListener {
                            navigator()?.goToChooseDifficult()
                        }
                    }
                    false -> {
                        resultLogo.setImageDrawable(getImageDrawable(R.drawable.logo_loose))
                        btnActionAfterGame.setImageDrawable(getImageDrawable(R.drawable.btn_again))
                        btnActionAfterGame.setOnClickListener {
                            navigator()?.goToMainScreen()
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

        @JvmStatic
        fun newInstance(isWin: Boolean) = ResultFragment().apply {
            arguments = Bundle().apply {
                putBoolean(IS_WIN, isWin)
            }
        }
    }
}