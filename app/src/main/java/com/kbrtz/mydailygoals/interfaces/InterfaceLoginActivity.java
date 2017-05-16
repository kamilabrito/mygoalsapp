package com.kbrtz.mydailygoals.interfaces;

import android.content.Context;
import android.os.Bundle;

import com.kbrtz.mydailygoals.model.User;

/**
 * Created by kamilabrito on 5/11/17.
 */

public interface InterfaceLoginActivity {

    User createUser(Bundle userInfo);

    void openMainActivity(User user);

    boolean isFirstBoot(Context context);

    void loadDataFirstBoot(Context context);

    User getCurrentUser();
}
