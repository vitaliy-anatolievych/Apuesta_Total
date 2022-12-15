package com.doriangrei.apueastawinapp.presentation.contract

import androidx.fragment.app.Fragment
import com.doriangrei.apueastawinapp.model.Level

fun Fragment?.navigator(): Navigator? {
    return this?.activity as Navigator?
}

interface Navigator {

    fun goToMainScreen()
    fun goToGameScreen(level: Level)
    fun goToScoreScreen(isWin: Boolean, level: Level)
    fun goToChooseDifficult(levels: ArrayList<Level>)
}