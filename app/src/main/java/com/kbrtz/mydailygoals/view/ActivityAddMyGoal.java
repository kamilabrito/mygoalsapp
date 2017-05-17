package com.kbrtz.mydailygoals.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.constants.Constants;
import com.kbrtz.mydailygoals.model.MyGoals;
import com.kbrtz.mydailygoals.util.GoalsUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.kbrtz.mydailygoals.presenter.PresenterAddMyGoalActivity;

/**
 * Created by kamilabrito on 5/8/17.
 */

public class ActivityAddMyGoal extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.my_goal_name_edt)
    EditText myGoalNameEdt;
    @BindView(R.id.my_goal_description_edt)
    EditText myGoalDescriptionEdt;
    @BindView(R.id.add_my_goal)
    Button addMyGoalBtn;
    @BindView(R.id.difficulty_spinner)
    Spinner difficultySpn;
    @BindView(R.id.toolbar_add_goal)
    Toolbar toolbar;

    private String goalName, goalDescription, difficultyLevel = "";
    private PresenterAddMyGoalActivity presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_add_goal);
        ButterKnife.bind(this);

        presenter = new PresenterAddMyGoalActivity(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.goals_difficulty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difficultySpn.setAdapter(adapter);

        addMyGoalBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_my_goal:
                if (isFormComplete()) {
                    goalName = myGoalNameEdt.getText().toString();
                    goalDescription = myGoalDescriptionEdt.getText().toString();
                    difficultyLevel = difficultySpn.getSelectedItem().toString();

                    MyGoals goal = new MyGoals();
                    goal.setGoalName(goalName);
                    goal.setGoalDescription(goalDescription);
                    goal.setGoalStatus(Constants.STATUS_DONE);
                    goal.setGoalValue(GoalsUtil.checkDifficultiLevel(this, difficultyLevel));
                    goal.setGoalType(1);

                    presenter.addMyGoalToList(goal);
                    finish();

                } else {
                    Toast.makeText(ActivityAddMyGoal.this, "Fill out form", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    private boolean isFormComplete() {
        if (!myGoalNameEdt.getText().toString().isEmpty() &&
                !myGoalDescriptionEdt.getText().toString().isEmpty()) {
            return true;
        }
        return false;
    }
}
