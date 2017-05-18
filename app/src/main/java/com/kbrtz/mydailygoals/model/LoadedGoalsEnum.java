package com.kbrtz.mydailygoals.model;

import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.constants.Constants;

/**
 * Holds the pre-loaded goals with its respective informations
 * Created by kamilabrito on 5/14/17.
 */

public enum LoadedGoalsEnum {

    GOAL_1(R.string.name_1, R.string.description_1, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_2(R.string.name_2, R.string.description_2, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_3(R.string.name_3, R.string.description_3, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_4(R.string.name_4, R.string.description_4, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_5(R.string.name_5, R.string.description_5, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_6(R.string.name_6, R.string.description_6, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_7(R.string.name_7, R.string.description_7, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_8(R.string.name_8, R.string.description_8, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_9(R.string.name_9, R.string.description_9, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED),
    GOAL_10(R.string.name_10, R.string.description_10, Constants.DIFFICULTY_EASY, Constants.STATUS_DONE,
            Constants.TYPE_PRE_LOADED);

    private int name;
    private int description;
    private int value;
    private int status;
    private int type;

    LoadedGoalsEnum(int name, int description, int value, int status, int type) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.status = status;
        this.type = type;
    }

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getValue() {
        return value;
    }

    public int getStatus() {
        return status;
    }

    public int getType() {
        return type;
    }
}
