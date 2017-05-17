package com.kbrtz.mydailygoals.util;

import android.content.Context;

import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.constants.Constants;


/**
 * Created by kamilabrito on 5/8/17.
 */

public final class GoalsUtil {


    public static int checkDifficultiLevel (Context context, String level) {

        String[] array = context.getResources().getStringArray(R.array.goals_difficulty);

        if(array[0].equals(level)) {
            return Constants.DIFFICULTY_EASY;
        } else if (array[1].equals(level)) {
            return Constants.DIFFICULTY_MODERATE;
        } else if (array[2].equals(level)) {
            return Constants.DIFFICULTY_HARD;
        } else {
            return Constants.DIFFICULTY_VERY_HARD;
        }

    }

    public static int checkUserLevel(int points) {

        if (points < 100) {
            return R.string.reward_1;
        } else if (points >= 100 && points < 500) {
            return R.string.reward_2;
        } else if (points >= 500 && points < 5000) {
            return R.string.reward_3;
        } else if (points >= 5000 && points < 100000) {
            return R.string.reward_4;
        } else if (points >= 100000) {
            return R.string.reward_5;
        }
        
        return 1;

    }
}
