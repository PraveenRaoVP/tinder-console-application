package com.tinder_application.repository;

public class UserToPreferencesRepository {
    private static UserToPreferencesRepository instance;

    private UserToPreferencesRepository() {}

    public static UserToPreferencesRepository getInstance() {
        if (instance == null) {
            instance = new UserToPreferencesRepository();
        }
        return instance;
    }
}
