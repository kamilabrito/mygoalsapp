package com.kbrtz.mydailygoals.presenter;

import android.content.Context;

import com.kbrtz.mydailygoals.constants.Constants;
import com.kbrtz.mydailygoals.dao.GoalsDataBaseDAO;
import com.kbrtz.mydailygoals.dao.UserDataBaseDAO;
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
    GoalsDataBaseDAO goalsDAO = new GoalsDataBaseDAO();
    UserDataBaseDAO userDAO = new UserDataBaseDAO();
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
        return goalsDAO.getMyGoalsList();
    }

    @Override
    public void markGoalAsDone(MyGoals currentGoal) {
        goalsDAO.markGoalAsDone(currentGoal);
    }

    @Override
    public void showEditListMode() {
        view.showEditListMode();
    }

    @Override
    public void addGoalToUserList(MyGoals currentGoal) {
        currentGoal.setGoalStatus(Constants.STATUS_IN_PROGRESS);
        goalsDAO.addGoalToUserList(currentGoal);

    }

    @Override
    public List<MyGoals> loadUnusedGoals() {
        return goalsDAO.getUnusedGoals();
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
        userDAO.countUserPoint(goalValue);
    }

    @Override
    public User getCurrentUser() {
        return userDAO.getCurrentUser();
    }

    public void editModeIsShowing(boolean b) {
        editModeIsShowing = b;
    }

    public boolean isEditModeShowing() {
        return editModeIsShowing;
    }

}
