package com.tinder_application.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tinder_application.models.Credentials;

import java.io.File;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class CredentialsRepository {
    private static CredentialsRepository instance;

    private CredentialsRepository() {

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

    private String fileNamePath = "./src/main/resources/credentials.json";

    // json functionality
    public void pushDataToJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            mapper.writeValue(file, credentialsMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pullDataFromJSON() {
        ObjectMapper mapper = new ObjectMapper();
        File file = new File(fileNamePath);
        try {
            credentialsMap.putAll(mapper.readValue(file, new TypeReference<Map<Integer, Credentials>>() {}));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCredentialsCount() {
        return credentialsMap.size();
    }

    public Credentials getCredentialsById(int credId) {
        return credentialsMap.get(credId);
    }

    public void updateCredentials(Credentials credentials) {
        credentialsMap.put(credentials.getCredId(), credentials);
    }
}
