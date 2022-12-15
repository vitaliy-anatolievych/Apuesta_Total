package com.doriangrei.apueastawinapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Level(
    val levelName: Int,
    val steps: Int,
    val countForWin: Int,
    val planetTask: Int,
    var isLock: Boolean
) :Parcelable
