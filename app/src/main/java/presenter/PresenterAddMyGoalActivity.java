package presenter;

import com.kbrtz.mydailygoals.dao.DataBaseDAO;
import com.kbrtz.mydailygoals.interfaces.InterfaceAddMyGoalActivity;
import com.kbrtz.mydailygoals.model.MyGoals;
import com.kbrtz.mydailygoals.view.ActivityAddMyGoal;

/**
 * Created by kamilabrito on 5/8/17.
 */

public class PresenterAddMyGoalActivity implements InterfaceAddMyGoalActivity {

    ActivityAddMyGoal view;
    DataBaseDAO createGoalsDAO = new DataBaseDAO();

    public PresenterAddMyGoalActivity(ActivityAddMyGoal view) {
        this.view = view;
    }

    @Override
    public void addMyGoalToList(MyGoals goal) {
        createGoalsDAO.addGoalManually(goal);
    }
}
