package com.kbrtz.mydailygoals.dao;

import com.kbrtz.mydailygoals.model.User;

import java.util.List;

/**
 * Created by kamilabrito on 5/18/17.
 */

public class UserDataBaseDAO {

    public User getCurrentUser() {
        List<User> user = User.listAll(User.class);
        User currentUser = user.get(0);
        return currentUser;
    }

    public void countUserPoint(int goalValue) {
        User user = getCurrentUser();
        int userPoints = user.getPoints();
        int updatedPoints = userPoints + goalValue;
        user.setPoints(updatedPoints);
        user.save();
    }

    public void createUser(User user) {
        user.save();
    }

}
