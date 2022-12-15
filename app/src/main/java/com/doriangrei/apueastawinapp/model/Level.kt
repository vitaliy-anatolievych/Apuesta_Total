package com.doriangrei.apueastawinapp.model

import android.graphics.Color

data class Level(
    val levelName: Int,
    val steps: Int,
    val countForWin: Int,
    val planetTask: Color,
    var isLock: Boolean
)
