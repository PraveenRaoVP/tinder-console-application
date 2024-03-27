package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserToPreferencesRepository {
    private static UserToPreferencesRepository instance;

    private UserToPreferencesRepository() {}

    public static UserToPreferencesRepository getInstance() {
        if (instance == null) {
            instance = new UserToPreferencesRepository();
        }
        return instance;
    }

    private Map<Integer, Integer> userIdToPrefIdMap = new HashMap<>();

    // json functions
    private String fileNamePath = "./src/main/resources/userToPreferences.json";

    public void pushDataToJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            mapper.writeValue(file, userIdToPrefIdMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pullDataFromJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            userIdToPrefIdMap.putAll(mapper.readValue(file, new TypeReference<Map<Integer, Integer>>() {
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
