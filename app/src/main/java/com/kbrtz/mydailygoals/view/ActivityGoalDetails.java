package com.kbrtz.mydailygoals.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.model.MyGoals;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.kbrtz.mydailygoals.presenter.PresenterGoalDetailActivity;

public class ActivityGoalDetails extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.detail_goal_name)
    TextView detailGoalNameTv;
    @BindView(R.id.detail_goal_description)
    TextView detailGoalDescriptionTv;
    @BindView(R.id.detail_goal_status)
    TextView detailGoalStatusTv;
    @BindView(R.id.detail_goal_type)
    TextView detailGoalTypeTv;
    @BindView(R.id.details_remove_button)
    Button removeGoalBtn;
    @BindView(R.id.toolbar_details)
    Toolbar toolbar;

    private MyGoals currentGoal;
    private PresenterGoalDetailActivity presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_details);
        ButterKnife.bind(this);

        presenter = new PresenterGoalDetailActivity();
        currentGoal = new MyGoals();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = this.getIntent().getExtras();
        if (b != null) {
            currentGoal = (MyGoals) b.getSerializable(MainActivity.GOAL_DETAIL_ACTIVITY);
            long goalid = b.getLong(MainActivity.GOAL_ID_DETAIL_ACTIVITY);
            detailGoalNameTv.setText(currentGoal.getGoalName());
            detailGoalDescriptionTv.setText(currentGoal.getGoalDescription());
            detailGoalStatusTv.setText(currentGoal.getGoalStatus() + "");
            detailGoalTypeTv.setText(currentGoal.getGoalType() + "");
            currentGoal.setId(goalid);
        }

        removeGoalBtn.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.details_remove_button:
                presenter.removeGoalFromUserList(currentGoal);
                finish();
        }
    }
}
