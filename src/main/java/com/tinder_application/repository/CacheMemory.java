package com.tinder_application.repository;

import com.tinder_application.models.Match;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

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

    public int calculateAge(String dateOfBirthString) {
        // Parse the date of birth string into a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the period between the date of birth and the current date
        Period period = Period.between(dateOfBirth, currentDate);

        // Return the age
        return period.getYears();
    }


}
