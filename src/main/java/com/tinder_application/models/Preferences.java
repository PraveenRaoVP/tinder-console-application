package com.tinder_application.models;

import com.tinder_application.models.enums.Genders;

import java.util.List;

public class Preferences {
    private int preferencesId;
    private int minAge;
    private int maxAge;
    private int distance;
    private String hobbies; // comma separated values
    private List<Genders> genders;

}
