package com.kbrtz.mydailygoals.model;

import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.constants.Constants;

/**
 * Created by kamilabrito on 5/14/17.
 */

public enum RewardsEnum {

    REWARD_1(R.string.reward_1, R.string.reward_description_1, Constants.DIFFICULTY_EASY),
    REWARD_2(R.string.reward_2, R.string.reward_description_2, Constants.DIFFICULTY_EASY),
    REWARD_3(R.string.reward_3, R.string.reward_description_3, Constants.DIFFICULTY_EASY),
    REWARD_4(R.string.reward_4, R.string.reward_description_4, Constants.DIFFICULTY_EASY),
    REWARD_5(R.string.reward_5, R.string.reward_description_5, Constants.DIFFICULTY_EASY);

    private int name;
    private int description;
    private int type;

    RewardsEnum(int name, int description, int type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public int getName() {
        return name;
    }

    public int getDescription() {
        return description;
    }

    public int getType() {
        return type;
    }
}
