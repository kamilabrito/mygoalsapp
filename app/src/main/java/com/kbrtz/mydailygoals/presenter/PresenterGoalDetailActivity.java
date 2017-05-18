package com.kbrtz.mydailygoals.presenter;

import com.kbrtz.mydailygoals.dao.GoalsDataBaseDAO;
import com.kbrtz.mydailygoals.interfaces.InterfaceGoalDetailActivity;
import com.kbrtz.mydailygoals.model.MyGoals;

/**
 * Created by kamilabrito on 5/8/17.
 */

public class PresenterGoalDetailActivity implements InterfaceGoalDetailActivity {

    private GoalsDataBaseDAO goalsDAO = new GoalsDataBaseDAO();

    @Override
    public void removeGoalFromUserList(MyGoals goal) {
        goalsDAO.removeGoalFromUserList(goal);
    }
}
