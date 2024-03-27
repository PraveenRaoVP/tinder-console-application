package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserToCredentialsRepository {
    private static UserToCredentialsRepository instance;

    private UserToCredentialsRepository() {userIdToCredIdMap.put(1,1);}

    public static UserToCredentialsRepository getInstance() {
        if (instance == null) {
            instance = new UserToCredentialsRepository();
        }
        return instance;
    }

    private Map<Integer, Integer> userIdToCredIdMap = new HashMap<>();

    public int getUserIdByCredId(int credId) {
        for (Map.Entry<Integer, Integer> entry : userIdToCredIdMap.entrySet()) {
            if (entry.getValue() == credId) {
                return entry.getKey();
            }
        }
        return -1;
    }

    //json functions
    private String fileNamePath = "./src/main/resources/userToCredentials.json";

    public void pushDataToJSON() {
         ObjectMapper mapper = new ObjectMapper();
         File file = new File(fileNamePath);
         try {
             mapper.writeValue(file, userIdToCredIdMap);
         } catch (Exception e) {
             e.printStackTrace();
         }
    }

    public void pullDataFromJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            userIdToCredIdMap.putAll(mapper.readValue(file, new TypeReference<Map<Integer, Integer>>(){}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
