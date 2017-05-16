package com.kbrtz.mydailygoals.model;

import android.content.Context;

import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by kamilabrito on 5/6/17.
 */

public class Rewards extends SugarRecord<Rewards> implements Serializable {

    private static final long serialVersionUID = -7060210544600464481L;

    private String name;
    private String description;
    private int type;

    public Rewards(String name, String description, int type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Rewards() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
