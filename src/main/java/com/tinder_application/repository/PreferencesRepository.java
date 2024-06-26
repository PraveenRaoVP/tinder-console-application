package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.Preferences;
import com.tinder_application.models.enums.Genders;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferencesRepository {
    private static PreferencesRepository instance;

    private PreferencesRepository() {}

    public static PreferencesRepository getInstance() {
        if (instance == null) {
            instance = new PreferencesRepository();
        }
        return instance;
    }

    private Map<Integer, Preferences> preferencesMap = new HashMap<>();

    // constants
    public static final int AGE_WEIGHT = 10;
    public static final int AGE_DIFFERENCE_WEIGHT = 5;
    public static final int MAX_AGE_DIFFERENCE = 100;
    public static final int DISTANCE_WEIGHT = 7;
    public static final int MAX_DISTANCE_DIFFERENCE = 50;
    public static final int HOBBIES_SCORE = 20;
    public static final int GENDER_SCORE = 15;

    //json functions
    private String fileNamePath = "./src/main/resources/preferences.json";

    public void pushDataToJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            mapper.writeValue(file, preferencesMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pullDataFromJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            preferencesMap.putAll(mapper.readValue(file, new TypeReference<Map<Integer, Preferences>>(){}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Preferences addPreferences(int userId, int minAge, int maxAge, int distance, String hobbies, List<Genders> gendersList) {
        int preferencesId = preferencesMap.size() + 1;
        Preferences preferences = new Preferences(preferencesId, minAge, maxAge, distance, hobbies, gendersList);
        preferencesMap.put(preferencesId, preferences);
        UserToPreferencesRepository.getInstance().addUserToPreferences(userId, preferencesId);
        return preferences;
    }

    public Preferences getPreferencesById(int preferencesId) {
        return preferencesMap.get(preferencesId);
    }
}
