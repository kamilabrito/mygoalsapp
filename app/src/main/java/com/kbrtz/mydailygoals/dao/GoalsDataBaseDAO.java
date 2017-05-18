package com.kbrtz.mydailygoals.dao;

import android.content.Context;

import com.kbrtz.mydailygoals.constants.Constants;
import com.kbrtz.mydailygoals.model.LoadedGoalsEnum;
import com.kbrtz.mydailygoals.model.MyGoals;
import com.kbrtz.mydailygoals.model.Rewards;
import com.kbrtz.mydailygoals.model.RewardsEnum;
import com.kbrtz.mydailygoals.model.User;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kamilabrito on 5/6/17.
 *
 * Populate goals database with pre-existing goals
 *
 */

public class GoalsDataBaseDAO {

   /* public void createRewards(Context context) {
        List<RewardsEnum> rewardsList = Arrays.asList(RewardsEnum.values());

        for (RewardsEnum r: rewardsList) {
            Rewards reward = new Rewards(context.getResources().getString(r.getName()),
                    context.getResources().getString(r.getDescription()), r.getType());
            reward.save();
        }
    }*/

    public void createGoals(Context context) {
        List<LoadedGoalsEnum> preLoadedGoalsList = Arrays.asList(LoadedGoalsEnum.values());
        for (LoadedGoalsEnum e: preLoadedGoalsList) {
            MyGoals goals = new MyGoals();
            goals.setGoalName(context.getResources().getString(e.getName()));
            goals.setGoalDescription(context.getResources().getString(e.getDescription()));
            goals.setGoalStatus(e.getStatus());
            goals.setGoalValue(e.getValue());
            goals.setGoalType(e.getType());
            goals.save();
        }
    }


    public List<MyGoals> getGoalsList() {
        List<MyGoals> goals = MyGoals.listAll(MyGoals.class);
        return goals;
    }

    public List<MyGoals> getUnusedGoals() {
        List<MyGoals> goals = MyGoals.findWithQuery(MyGoals.class, "Select * from MY_GOALS where GOAL_STATUS != ?", "1");
        return goals;
    }

    public List<MyGoals> getMyGoalsList() {
        List<MyGoals> goals = MyGoals.findWithQuery(MyGoals.class, "Select * from MY_GOALS where GOAL_STATUS = ?", "1");
        return goals;
    }

    public void addGoalToUserList(MyGoals currentGoal) {
        MyGoals updateGoal = MyGoals.findById(MyGoals.class, currentGoal.getId());
        updateGoal.setGoalStatus(Constants.STATUS_IN_PROGRESS);
        updateGoal.save();
    }

    public void markGoalAsDone(MyGoals currentGoal) {
        MyGoals updateGoal = MyGoals.findById(MyGoals.class, currentGoal.getId());
        updateGoal.setGoalStatus(Constants.STATUS_DONE);
        updateGoal.save();
    }

    public void addGoalManually(MyGoals goal) {
        goal.save();
    }

    public void removeGoalFromUserList(MyGoals goal) {
        MyGoals updateGoal = MyGoals.findById(MyGoals.class, goal.getId());
        updateGoal.setGoalStatus(Constants.STATUS_REMOVED);
        updateGoal.save();
    }

}
