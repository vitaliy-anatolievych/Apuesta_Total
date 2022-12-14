package com.doriangrei.apueastawinapp.presentation.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.doriangrei.apueastawinapp.R
import com.doriangrei.apueastawinapp.model.Level
import com.doriangrei.apueastawinapp.presentation.contract.navigator
import com.doriangrei.apueastawinapp.presentation.util.LevelAdapter

class LevelFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_levels, container, false).also {
            val rvView = it.findViewById<RecyclerView>(R.id.rv_missions)
            val listLevels = arguments?.getParcelableArrayList<Level>(LIST_LEVELS) as ArrayList<Level>

            LevelAdapter().apply {
                this.listLevels = listLevels
                this.setOnLevelClickListener { level ->
                    navigator()?.goToGameScreen(level)
                }

                rvView.layoutManager = GridLayoutManager(requireContext(), 4)
                rvView.adapter = this
            }
        }
    }

    companion object {
        private const val LIST_LEVELS = "list_levels"

        @JvmStatic
        fun newInstance(listLevel: java.util.ArrayList<Level>) = LevelFragment().apply {
            arguments = Bundle().apply {
                putParcelableArrayList(LIST_LEVELS, listLevel)
            }
        }
    }
}