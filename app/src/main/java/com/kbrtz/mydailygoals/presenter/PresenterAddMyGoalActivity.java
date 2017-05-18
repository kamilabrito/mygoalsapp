package com.kbrtz.mydailygoals.presenter;

import com.kbrtz.mydailygoals.dao.GoalsDataBaseDAO;
import com.kbrtz.mydailygoals.interfaces.InterfaceAddMyGoalActivity;
import com.kbrtz.mydailygoals.model.MyGoals;
import com.kbrtz.mydailygoals.view.ActivityAddMyGoal;

/**
 * Created by kamilabrito on 5/8/17.
 */

public class PresenterAddMyGoalActivity implements InterfaceAddMyGoalActivity {

    ActivityAddMyGoal activityAddMyGoalview;
    GoalsDataBaseDAO goalsDAO = new GoalsDataBaseDAO();

    public PresenterAddMyGoalActivity(ActivityAddMyGoal view) {
        this.activityAddMyGoalview = view;
    }

    @Override
    public void addMyGoalToList(MyGoals goal) {
        goalsDAO.addGoalManually(goal);
    }
}
