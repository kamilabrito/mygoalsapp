package presenter;

import com.kbrtz.mydailygoals.dao.DataBaseDAO;
import com.kbrtz.mydailygoals.interfaces.InterfaceGoalDetailActivity;
import com.kbrtz.mydailygoals.model.MyGoals;

/**
 * Created by kamilabrito on 5/8/17.
 */

public class PresenterGoalDetailActivity implements InterfaceGoalDetailActivity {

    private DataBaseDAO createGoalsDAO = new DataBaseDAO();

    @Override
    public void removeGoalFromUserList(MyGoals goal) {
        createGoalsDAO.removeGoalFromUserList(goal);
    }
}
