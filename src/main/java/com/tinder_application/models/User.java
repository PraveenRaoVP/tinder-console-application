package com.tinder_application.models;

import com.tinder_application.models.enums.Genders;

public class User {
    private int userId;
    private String userName;
    private String emailId;
    private String dateOfBirth;
    private String bio;
    private String height;
    private String languagesKnown;
    private String location;
    private Genders gender;
    private int eloRating;

    public User(int userId, String userName, String emailId, String dateOfBirth, String bio, String height, String languagesKnown, String location, Genders gender, int eloRating) {
        this.userId = userId;
        this.userName = userName;
        this.emailId = emailId;
        this.dateOfBirth = dateOfBirth;
        this.bio = bio;
        this.height = height;
        this.languagesKnown = languagesKnown;
        this.location = location;
        this.gender = gender;
        this.eloRating = eloRating;
    }



    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getEloRating() {
        return eloRating;
    }

    public void setEloRating(int eloRating) {
        this.eloRating = eloRating;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getLanguagesKnown() {
        return languagesKnown;
    }

    public void setLanguagesKnown(String languagesKnown) {
        this.languagesKnown = languagesKnown;
    }
}
