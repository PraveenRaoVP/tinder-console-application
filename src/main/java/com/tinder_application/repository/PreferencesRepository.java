package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.Preferences;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
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
}
