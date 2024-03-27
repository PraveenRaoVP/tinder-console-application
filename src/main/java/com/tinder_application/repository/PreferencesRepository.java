package com.tinder_application.repository;

public class PreferencesRepository {
    private static PreferencesRepository instance;

    private PreferencesRepository() {}

    public static PreferencesRepository getInstance() {
        if (instance == null) {
            instance = new PreferencesRepository();
        }
        return instance;
    }
}
