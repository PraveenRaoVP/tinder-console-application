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
        System.out.println("Exiting...");
    }
}
