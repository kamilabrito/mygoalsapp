package com.kbrtz.mydailygoals.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.kbrtz.mydailygoals.R;
import com.kbrtz.mydailygoals.component.RecyclerViewEmptySupport;
import com.kbrtz.mydailygoals.interfaces.OnItemClickListener;
import com.kbrtz.mydailygoals.model.MyGoals;
import com.kbrtz.mydailygoals.model.User;
import com.kbrtz.mydailygoals.presenter.PresenterMainActivity;
import com.kbrtz.mydailygoals.util.GoalsUtil;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.goals_recyclerview)
    RecyclerViewEmptySupport goalsRecyclerView;
    @BindView(R.id.add_my_goal)
    Button addMyGoalBtn;
    @BindView(R.id.no_goals_text)
    TextView noGoalsTv;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private GoalsRecyclerAdapter goalsListAdapter;
    public static final String GOAL_DETAIL_ACTIVITY = "GOAL_DETAILS";
    public static final String GOAL_ID_DETAIL_ACTIVITY = "GOAL_ID";
    public PresenterMainActivity presenter;
    private User currentUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        presenter = new PresenterMainActivity(this);
        currentUser = new User();
        goalsListAdapter = new GoalsRecyclerAdapter(this);
        addMyGoalBtn.setOnClickListener(this);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        if (intent != null) {
            currentUser =  (User) intent.getSerializableExtra(ActivityLogin.MAIN_ACTIVITY);
        }

        goalsListAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(MyGoals item) {
            presenter.openDetailActivity(item);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View header = navigationView.getHeaderView(0);
        TextView userNameTv = (TextView) header.findViewById(R.id.user_name_tv);
        final TextView userLevelTv = (TextView) header.findViewById(R.id.user_level_tv);
        final TextView userPointsTv = (TextView) header.findViewById(R.id.user_points_tv);
        CircleImageView userPhotoIv = (CircleImageView) header.findViewById(R.id.user_photo_iv);
        userNameTv.setText(currentUser.getName());
        Picasso.with(this)
                .load(currentUser.getPicture())
                .resize(80, 80)
                .centerCrop()
                .into(userPhotoIv);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                User user = presenter.getCurrentUser();
                userPointsTv.setText(user.getPoints() + " " + getResources().getString(R.string.points));
                userLevelTv.setText(getResources().getString(GoalsUtil.checkUserLevel(user.getPoints())));
            }

            @Override
            public void onDrawerClosed(View drawerView) {
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        };

        drawer.addDrawerListener(listener);

    }



    public void openDetailActivity(MyGoals item) {
        Intent i = new Intent();
        Bundle b = new Bundle();
        b.putSerializable(GOAL_DETAIL_ACTIVITY, item);
        b.putLong(GOAL_ID_DETAIL_ACTIVITY, item.getId());
        i.putExtras(b);
        i.setClass(this, ActivityGoalDetails.class);
        startActivity(i);
    }

    public void openAddMyGoalActivity() {
        Intent intent = new Intent(MainActivity.this, ActivityAddMyGoal.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_my_goal:
                presenter.openAddMyGoalActivity();
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_edit_mode:
                if (!presenter.isEditModeShowing()) {
                    presenter.showEditListMode();
                } else {
                    presenter.hideEditMode();
                }
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_completed_goals) {
            //open completed goals list
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (presenter.isEditModeShowing()) {
            showEditListMode();
        } else {
            hideEditMode();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    public void hideEditMode() {
        presenter.editModeIsShowing(false);
        addMyGoalBtn.setVisibility(View.GONE);
        goalsListAdapter.setGoalsList(presenter.getUserGoalsList());
        goalsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        goalsRecyclerView.setEmptyView(noGoalsTv);
        goalsRecyclerView.setAdapter(goalsListAdapter);
        goalsListAdapter.notifyDataSetChanged();
    }

    public void showEditListMode() {
        presenter.editModeIsShowing(true);
        addMyGoalBtn.setVisibility(View.VISIBLE);
        goalsListAdapter.setGoalsList(presenter.loadUnusedGoals());
        goalsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        goalsRecyclerView.setAdapter(goalsListAdapter);
        goalsRecyclerView.setEmptyView(noGoalsTv);
        goalsListAdapter.notifyDataSetChanged();
    }



}
