package com.kbrtz.mydailygoals.presenter;

import android.content.Context;

import com.kbrtz.mydailygoals.constants.Constants;
import com.kbrtz.mydailygoals.dao.DataBaseDAO;
import com.kbrtz.mydailygoals.interfaces.InterfaceMainActivity;
import com.kbrtz.mydailygoals.model.MyGoals;
import com.kbrtz.mydailygoals.model.User;
import com.kbrtz.mydailygoals.view.MainActivity;

import java.util.List;

/**
 * Created by kamilabrito on 5/8/17.
 */

public class PresenterMainActivity implements InterfaceMainActivity {

    private MainActivity view;
    private Context context;
    DataBaseDAO createGoalsDAO = new DataBaseDAO();
    private boolean editModeIsShowing;

    public PresenterMainActivity(MainActivity view) {
        this.view = view;
    }

    public PresenterMainActivity (Context context) {
        this.context = context;
    }


    @Override
    public void openDetailActivity(MyGoals item) {
        view.openDetailActivity(item);
    }

    @Override
    public List<MyGoals> getUserGoalsList() {
        return createGoalsDAO.getMyGoalsList();
    }

    @Override
    public void markGoalAsDone(MyGoals currentGoal) {
        createGoalsDAO.markGoalAsDone(currentGoal);
    }

    @Override
    public void showEditListMode() {
        view.showEditListMode();
    }

    @Override
    public void addGoalToUserList(MyGoals currentGoal) {
        currentGoal.setGoalStatus(Constants.STATUS_IN_PROGRESS);
        createGoalsDAO.addGoalToUserList(currentGoal);

    }

    @Override
    public List<MyGoals> loadUnusedGoals() {
        return createGoalsDAO.getUnusedGoals();
    }

    @Override
    public void openAddMyGoalActivity() {
        view.openAddMyGoalActivity();
    }

    @Override
    public void hideEditMode() {
        view.hideEditMode();
    }

    @Override
    public void countUserPoint(int goalValue) {
        createGoalsDAO.countUserPoint(goalValue);
    }

    @Override
    public User getCurrentUser() {
        return createGoalsDAO.getCurrentUser();
    }

    public void editModeIsShowing(boolean b) {
        editModeIsShowing = b;
    }

    public boolean isEditModeShowing() {
        return editModeIsShowing;
    }

}
