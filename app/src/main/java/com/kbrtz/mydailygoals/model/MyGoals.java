package com.kbrtz.mydailygoals.model;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by kamilabrito on 5/6/17.
 */
public class MyGoals extends SugarRecord<MyGoals> implements Serializable {

    private static final long serialVersionUID = -7060210544600464481L;

    private String goalName;
    private String goalDescription;
    private int goalValue;
    private int goalStatus;
    private int goalType;

    public MyGoals () {

    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public String getGoalDescription() {
        return goalDescription;
    }

    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    public int getGoalValue() {
        return goalValue;
    }

    public void setGoalValue(int goalValue) {
        this.goalValue = goalValue;
    }

    public int getGoalStatus() {
        return goalStatus;
    }

    public void setGoalStatus(int goalStatus) {
        this.goalStatus = goalStatus;
    }

    public int getGoalType() {
        return goalType;
    }

    public void setGoalType(int goalType) {
        this.goalType = goalType;
    }
}
