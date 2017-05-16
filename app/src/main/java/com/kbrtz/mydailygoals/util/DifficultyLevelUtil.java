package com.kbrtz.mydailygoals.util;

import android.content.Context;

import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.constants.Constants;


/**
 * Created by kamilabrito on 5/8/17.
 */

public final class DifficultyLevelUtil {


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
}
