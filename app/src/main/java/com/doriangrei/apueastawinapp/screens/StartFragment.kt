package com.doriangrei.apueastawinapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.doriangrei.apueastawinapp.R
import com.doriangrei.apueastawinapp.contract.navigator

class StartFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false).apply {
            this.findViewById<ImageButton>(R.id.btn_start).setOnClickListener {
                navigator()?.goToGameScreen(24)
            }
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = StartFragment()
    }
}