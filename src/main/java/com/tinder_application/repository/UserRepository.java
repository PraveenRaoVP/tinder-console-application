package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.User;
import com.tinder_application.models.enums.Genders;

import java.io.File;
import java.util.*;

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

    public User addUser(String userName, String emailId, String dob, String bio, String height, String languages, String location, Genders gender) {
        int userId = usersMap.size() + 1;
        User user = new User(userId, userName, emailId, dob, bio, height, languages, location, gender, 0);
        usersMap.put(userId, user);
        return user;
    }

    public User getUserById(int currentUserId) {
        return usersMap.get(currentUserId);
    }

    public void updateUser(User currentUser) {
        usersMap.put(currentUser.getUserId(), currentUser);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(usersMap.values());
    }
}
