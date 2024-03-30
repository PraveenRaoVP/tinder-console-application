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

    public Preferences(int preferencesId, int minAge, int maxAge, int distance, String hobbies, List<Genders> genders) {
        this.preferencesId = preferencesId;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.distance = distance;
        this.hobbies = hobbies;
        this.genders = genders;
    }

    public Preferences() {}

    public int getPreferencesId() {
        return preferencesId;
    }

    public void setPreferencesId(int preferencesId) {
        this.preferencesId = preferencesId;
    }

    public int getMinAge() {
        return minAge;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public List<Genders> getGenders() {
        return genders;
    }

    public void setGenders(List<Genders> genders) {
        this.genders = genders;
    }
}
