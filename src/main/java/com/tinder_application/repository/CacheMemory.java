package com.tinder_application.repository;

public class CacheMemory {
    private static CacheMemory instance;

    private CacheMemory() {
    }

    public static CacheMemory getInstance() {
        if (instance == null) {
            instance = new CacheMemory();
        }
        return instance;
    }

    private int currentUserId;

    public int getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }

    public void handleExit() {
        // push all data to json
        System.out.println("Exiting...");
        UserRepository.getInstance().pushDataToJSON();
        MatchRepository.getInstance().pushDataToJSON();
        MessageRepository.getInstance().pushDataToJSON();
        ConversationsRepository.getInstance().pushDataToJSON();
        CredentialsRepository.getInstance().pushDataToJSON();
        UserRepository.getInstance().pushDataToJSON();
        UserToCredentialsRepository.getInstance().pushDataToJSON();
        UserToPreferencesRepository.getInstance().pushDataToJSON();
    }
}
