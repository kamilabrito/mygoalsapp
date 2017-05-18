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

    /**
     * return goal' name
     * @return
     */
    public String getGoalName() {
        return goalName;
    }

    /**
     * set goal' name
     * @param goalName
     */
    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    /**
     * return goal's description
     * @return
     */
    public String getGoalDescription() {
        return goalDescription;
    }

    /**
     * set goal's description
     * @param goalDescription
     */
    public void setGoalDescription(String goalDescription) {
        this.goalDescription = goalDescription;
    }

    /**
     * return goal's value. how many points the goal is worth
     * @return
     */
    public int getGoalValue() {
        return goalValue;
    }

    /**
     * set goal's value. how many points the goal is worth
     * @param goalValue
     */
    public void setGoalValue(int goalValue) {
        this.goalValue = goalValue;
    }

    /**
     * return goal's current status
     * @return
     */
    public int getGoalStatus() {
        return goalStatus;
    }

    /**
     * set goal's status
     * @param goalStatus
     */
    public void setGoalStatus(int goalStatus) {
        this.goalStatus = goalStatus;
    }

    /**
     * return goal's type
     * @return
     */
    public int getGoalType() {
        return goalType;
    }

    /**
     * set goal's type
     * @param goalType
     */
    public void setGoalType(int goalType) {
        this.goalType = goalType;
    }
}
