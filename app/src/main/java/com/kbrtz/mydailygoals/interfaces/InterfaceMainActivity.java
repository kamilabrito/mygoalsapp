package com.kbrtz.mydailygoals.interfaces;

import com.kbrtz.mydailygoals.model.MyGoals;

import java.util.List;

/**
 * Created by kamilabrito on 5/8/17.
 */

public interface InterfaceMainActivity {

    void openDetailActivity(MyGoals item);

    List<MyGoals> getUserGoalsList();

    void markGoalAsDone(MyGoals currentGoal);

    void showEditListMode();

    void addGoalToUserList(MyGoals currentGoal);

    List<MyGoals> loadUnusedGoals();

    void openAddMyGoalActivity();

    void hideEditMode();
}
