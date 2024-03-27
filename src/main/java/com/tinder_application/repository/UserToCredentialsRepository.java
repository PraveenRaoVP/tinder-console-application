package com.tinder_application.repository;

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
}
