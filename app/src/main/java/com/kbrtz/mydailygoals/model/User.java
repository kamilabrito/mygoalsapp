package com.kbrtz.mydailygoals.model;

import com.orm.SugarRecord;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kamilabrito on 5/6/17.
 */

public class User extends SugarRecord<User> implements Serializable {

    private static final long serialVersionUID = -7060210544600464481L;

    private String facebookId;
    private String name;
    private String lastName;
    private String email;
    private String picture;
    private int points;


    /**
     * User constructor
     * @param name
     * @param lastName
     * @param email
     * @param picture
     * @param points
     */
    public User(String name, String lastName, String email, String picture, int points) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.picture = picture;
        this.points = points;
    }

    public User() {
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }
}
