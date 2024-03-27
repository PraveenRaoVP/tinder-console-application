package com.tinder_application.repository;

import com.tinder_application.models.Credentials;

import java.util.HashMap;
import java.util.Map;

public class CredentialsRepository {
    private static CredentialsRepository instance;

    private CredentialsRepository() {
        credentialsMap.put(1,new Credentials(1, "user1@gmail.com", "user1"));
    }

    public static CredentialsRepository getInstance() {
        if (instance == null) {
            instance = new CredentialsRepository();
        }
        return instance;
    }

    private Map<Integer, Credentials> credentialsMap = new HashMap<>();

    public void addCredentials(String username, String password) {
        int credId = credentialsMap.size() + 1;
        credentialsMap.put(credId, new Credentials(credId, username, password));
    }

    public Credentials getCredentialsByEmail(String email) {
        for (Credentials credentials : credentialsMap.values()) {
            if (credentials.getEmail().equals(email)) {
                return credentials;
            }
        }
        return null;
    }

    public boolean checkIfDuplicateEmailExists(String email) {
        Credentials credentials = getCredentialsByEmail(email);
        return credentials != null;
    }

}
