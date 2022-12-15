package com.doriangrei.apueastawinapp.presentation.util;

import android.graphics.Color;

import com.doriangrei.apueastawinapp.R;

public class Tools {

    public static int getImage(int color) {
        switch (color) {
            case Color.GREEN: return R.drawable.ball_green;
            case Color.BLUE: return R.drawable.ball_blue;
            case Color.YELLOW: return R.drawable.ball_yellow;
            case Color.BLACK: return R.drawable.ball_brown;
        }
        return R.drawable.ball_moon;
    }
}
