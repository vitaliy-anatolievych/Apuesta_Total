package com.doriangrei.apueastawinapp.controller

import android.graphics.Color
import com.doriangrei.apueastawinapp.model.Level

object LevelsSettings {

    fun getDefaultLevels(): ArrayList<Level> {
        return ArrayList<Level>().apply {
            this.add(
                Level(
                    levelName = 1,
                    steps = 24,
                    countForWin = 24,
                    planetTask = Color.YELLOW,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 2,
                    steps = 24,
                    countForWin = 24,
                    planetTask = Color.BLACK,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 3,
                    steps = 24,
                    countForWin = 30,
                    planetTask = Color.GREEN,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 4,
                    steps = 24,
                    countForWin = 35,
                    planetTask = Color.YELLOW,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 5,
                    steps = 30,
                    countForWin = 40,
                    planetTask = Color.BLUE,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 6,
                    steps = 30,
                    countForWin = 42,
                    planetTask = Color.GREEN,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 7,
                    steps = 35,
                    countForWin = 44,
                    planetTask = Color.BLACK,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 8,
                    steps = 35,
                    countForWin = 56,
                    planetTask = Color.BLUE,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 9,
                    steps = 37,
                    countForWin = 58,
                    planetTask = Color.YELLOW,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 10,
                    steps = 40,
                    countForWin = 60,
                    planetTask = Color.BLUE,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 11,
                    steps = 44,
                    countForWin = 65,
                    planetTask = Color.GREEN,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 12,
                    steps = 45,
                    countForWin = 67,
                    planetTask = Color.YELLOW,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 13,
                    steps = 49,
                    countForWin = 68,
                    planetTask = Color.BLACK,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 14,
                    steps = 51,
                    countForWin = 71,
                    planetTask = Color.YELLOW,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 15,
                    steps = 60,
                    countForWin = 73,
                    planetTask = Color.GREEN,
                    false
                )
            )

            this.add(
                Level(
                    levelName = 16,
                    steps = 63,
                    countForWin = 75,
                    planetTask = Color.BLACK,
                    false
                )
            )
        }
    }
}