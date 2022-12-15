package com.doriangrei.apueastawinapp.presentation.contract

import androidx.fragment.app.Fragment
import com.doriangrei.apueastawinapp.model.Level

fun Fragment?.navigator(): ApuestaNavigator? {
    return this?.activity as ApuestaNavigator?
}

interface ApuestaNavigator {

    fun goToApuestaMainScreen()
    fun goToGameScreen(level: Level)
    fun goToScoreScreen(isWin: Boolean, level: Level)
    fun goToChooseDifficult(levels: ArrayList<Level>)
}