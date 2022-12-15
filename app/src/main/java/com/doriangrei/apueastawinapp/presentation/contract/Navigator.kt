package com.doriangrei.apueastawinapp.presentation.contract

import androidx.fragment.app.Fragment

fun Fragment?.navigator(): Navigator? {
    return this?.activity as Navigator?
}

interface Navigator {

    fun goToMainScreen()
    fun goToGameScreen(steps: Int)
    fun goToScoreScreen(isWin: Boolean)
    fun goToChooseDifficult()
}