package com.doriangrei.apueastawinapp.controller;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.doriangrei.apueastawinapp.databinding.FragmentGameBinding;
import com.doriangrei.apueastawinapp.model.Level;
import com.doriangrei.apueastawinapp.presentation.contract.GameResultListener;
import com.doriangrei.apueastawinapp.presentation.view.Board;

import java.util.Arrays;

public class GameManager {

    @SuppressLint("ClickableViewAccessibility")
    public static void initGame(GameResultListener resultListener, Level level, Integer num_rows, Integer num_col, FragmentGameBinding binding, Activity activity) {
        LinearLayout tableLayout = binding.subLinear;
        TextView stepView = binding.StepsTextView;
        stepView.setText(String.valueOf(level.component2()));
        Board board = new Board(resultListener, num_rows,num_col, activity, binding.rootGame, stepView, binding.CountView,new TextView[]{binding.QuestionTextView}, new ImageView[]{binding.QuestionImage}, Arrays.asList(level.component4()), Arrays.asList(level.component3()));
        for (int i = 0; i < num_rows; i++) {

            TableRow tableRow = new TableRow(activity);

            tableRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT,
                    TableRow.LayoutParams.WRAP_CONTENT, 0));

            tableRow.setBackgroundColor(Color.TRANSPARENT);
            tableRow.setClipChildren(false);
            for (int j = 0; j < num_col; j++) {

                int finalI = i;
                int finalJ = j;

                board.getImages()[i][j].setOnTouchListener(new OnSwipeListener(activity) {
                    public void onSwipeTop() {
                        stepView.setText(String.valueOf(Integer.parseInt((String) stepView.getText()) - 1));
                        final ObjectAnimator[] animation = {ObjectAnimator.ofFloat(board.getImages()[finalI - 1][finalJ], "translationY", board.getImages()[finalI][finalJ].getMeasuredHeight()), ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ], "translationY", - board.getImages()[finalI][finalJ].getMeasuredHeight())};
                        animation[1].setDuration(100);
                        animation[0].setDuration(100);
                        animation[1].start();
                        animation[0].start();
                        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE, WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        final Handler handler = new Handler();
                        handler.postDelayed(() -> {
                            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

                            if(board.isValidSwap(finalI, finalJ, finalI - 1, finalJ)) {
                                animation[0].setDuration(0);
                                animation[0].reverse();
                                animation[1].setDuration(0);
                                animation[1].reverse();
                                board.makeSwap(finalI, finalJ, finalI - 1, finalJ, activity);

                                //refreshTable(num_rows, num_col, board);
                            } else {
                                animation[1] = ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ], "translationY", 0f);
                                animation[1].setDuration(200);
                                animation[1].start();
                                animation[0] = ObjectAnimator.ofFloat(board.getImages()[finalI-1][finalJ], "translationY", 0f);
                                animation[0].setDuration(200);
                                animation[0].start();
                            }
                        }, 500);



                    }
                    public void onSwipeRight() {
                        stepView.setText(String.valueOf(Integer.parseInt((String) stepView.getText()) - 1));
                        final ObjectAnimator[] animation = {ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ+1], "translationX", -board.getImages()[finalI][finalJ].getMeasuredWidth()),ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ], "translationX", board.getImages()[finalI][finalJ].getMeasuredWidth())};
                        animation[1].setDuration(100);
                        animation[0].setDuration(100);
                        animation[1].start();
                        animation[0].start();
                        final Handler handler = new Handler();
                        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        handler.postDelayed(() -> {
                            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            if(board.isValidSwap(finalI, finalJ, finalI, finalJ+1)) {
                                animation[0].setDuration(0);
                                animation[0].reverse();
                                animation[1].setDuration(0);
                                animation[1].reverse();
                                board.makeSwap(finalI,finalJ,finalI,finalJ+1,activity);

                            } else {
                                animation[1] = ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ], "translationX", 0f);
                                animation[1].setDuration(200);
                                animation[1].start();
                                animation[0] = ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ+1], "translationX", 0f);
                                animation[0].setDuration(200);
                                animation[0].start();
                            }
                        }, 500);

                    }
                    public void onSwipeLeft() {

                        final ObjectAnimator[] animation = {ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ-1], "translationX", board.getImages()[finalI][finalJ].getMeasuredWidth()), ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ], "translationX", -board.getImages()[finalI][finalJ].getMeasuredWidth())};
                        stepView.setText(String.valueOf(Integer.parseInt((String) stepView.getText()) - 1));
                        animation[1].setDuration(100);
                        animation[0].setDuration(100);
                        animation[1].start();
                        animation[0].start();
                        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        final Handler handler = new Handler();
                        handler.postDelayed(() -> {
                            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            if(board.isValidSwap(finalI, finalJ, finalI, finalJ-1)) {
                                animation[0].setDuration(0);
                                animation[0].reverse();
                                animation[1].setDuration(0);
                                animation[1].reverse();
                                board.makeSwap(finalI, finalJ, finalI, finalJ-1, activity);
                            } else {
                                animation[1] = ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ], "translationX", 0f);
                                animation[1].setDuration(200);
                                animation[1].start();
                                animation[0] = ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ-1], "translationX", 0f);
                                animation[0].setDuration(200);
                                animation[0].start();
                            }
                        }, 500);

                    }
                    public void onSwipeBottom() {

                        final ObjectAnimator[] animation = {ObjectAnimator.ofFloat(board.getImages()[finalI + 1][finalJ], "translationY", -board.getImages()[finalI][finalJ].getMeasuredHeight()),ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ], "translationY", board.getImages()[finalI][finalJ].getMeasuredHeight())};
                        stepView.setText(String.valueOf(Integer.parseInt((String) stepView.getText()) - 1));
                        animation[1].setDuration(100);
                        animation[0].setDuration(100);
                        animation[1].start();
                        animation[0].start();
                        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                        final Handler handler = new Handler();
                        handler.postDelayed(() -> {
                            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                            if(board.isValidSwap(finalI, finalJ, finalI + 1, finalJ)) {
                                animation[0].setDuration(0);
                                animation[0].reverse();
                                animation[1].setDuration(0);
                                animation[1].reverse();
                                board.makeSwap(finalI, finalJ, finalI + 1, finalJ, activity);

                            } else {
                                animation[1] = ObjectAnimator.ofFloat(board.getImages()[finalI][finalJ], "translationY", 0f);
                                animation[1].setDuration(200);
                                animation[1].start();
                                animation[0] = ObjectAnimator.ofFloat(board.getImages()[finalI+1][finalJ], "translationY", 0f);
                                animation[0].setDuration(200);
                                animation[0].start();
                            }
                        }, 500);


                    }

                });
                tableRow.addView(board.getImages()[i][j], j);
            }

            tableLayout.addView(tableRow, i);
        }
    }
}
