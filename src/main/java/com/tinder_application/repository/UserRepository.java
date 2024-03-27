package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.User;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private static UserRepository instance;

    private UserRepository() {}

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    private Map<Integer, User> usersMap = new HashMap<>();

    //json functions
    private String fileNamePath = "./src/main/resources/users.json";
    public void pushDataToJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            mapper.writeValue(file, usersMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pullDataFromJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            usersMap.clear();
            usersMap.putAll(mapper.readValue(file, new TypeReference<Map<Integer, User>>() {
            }));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
