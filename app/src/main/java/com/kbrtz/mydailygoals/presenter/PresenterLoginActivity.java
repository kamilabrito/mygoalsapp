package com.kbrtz.mydailygoals.presenter;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.kbrtz.mydailygoals.constants.Constants;
import com.kbrtz.mydailygoals.dao.GoalsDataBaseDAO;
import com.kbrtz.mydailygoals.dao.UserDataBaseDAO;
import com.kbrtz.mydailygoals.interfaces.InterfaceLoginActivity;
import com.kbrtz.mydailygoals.model.User;
import com.kbrtz.mydailygoals.view.ActivityLogin;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by kamilabrito on 5/11/17.
 */

public class PresenterLoginActivity implements InterfaceLoginActivity {

    ActivityLogin view;
    GoalsDataBaseDAO goalsDAO = new GoalsDataBaseDAO();
    UserDataBaseDAO userDAO = new UserDataBaseDAO();

    public PresenterLoginActivity(ActivityLogin view) {
        this.view = view;
    }

    @Override
    public User createUser(Bundle userInfo) {

        User newUser = new User();
        newUser.setFacebookId(userInfo.getString(Constants.FACEBOOK_ID));
        newUser.setName(userInfo.getString(Constants.FIRST_NAME));
        newUser.setLastName(userInfo.getString(Constants.LAST_NAME));
        newUser.setEmail(userInfo.getString(Constants.EMAIL));
        newUser.setPicture(userInfo.getString(Constants.PROFILE_PIC));
        newUser.setPoints(0);

        //saving user on database
        userDAO.createUser(newUser);

        return newUser;
    }

    @Override
    public void openMainActivity() {
        view.openMainActivity();
    }

    @Override
    public boolean isFirstBoot(Context context) {

        String MY_PREFS_NAME = "FirstBootPrefs";
        String FIRST_BOOT = "firstboot";

        SharedPreferences prefs = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        Boolean restoredBool = prefs.getBoolean(FIRST_BOOT, true);
        if (restoredBool == true) {
            SharedPreferences.Editor editor = context.getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
            editor.putBoolean(FIRST_BOOT, false);
            editor.commit();

            return true;
        }

        return false;
    }

    @Override
    public void loadDataFirstBoot(Context context) {
        goalsDAO.createGoals(context);
    }

}
