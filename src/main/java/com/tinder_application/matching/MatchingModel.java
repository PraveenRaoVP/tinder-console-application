package com.tinder_application.matching;

import com.tinder_application.models.Preferences;
import com.tinder_application.models.User;
import com.tinder_application.models.enums.Genders;
import com.tinder_application.repository.CacheMemory;
import com.tinder_application.repository.PreferencesRepository;
import com.tinder_application.repository.UserRepository;
import com.tinder_application.repository.UserToPreferencesRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

class SimilarityComparator implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        int similarityScore1 = calculateSimilarityScore(PreferencesRepository.getInstance().getPreferencesById(UserToPreferencesRepository.getInstance().getPreferencesIdByUserId(o1.getUserId())));
        int similarityScore2 = calculateSimilarityScore(PreferencesRepository.getInstance().getPreferencesById(UserToPreferencesRepository.getInstance().getPreferencesIdByUserId(o2.getUserId())));
        return similarityScore2 - similarityScore1; // Sort in descending order
    }

    public int calculateSimilarityScore(Preferences targetPreferences) {
        // Initialize the similarity score
        int similarityScore = 0;
        User currentUser = UserRepository.getInstance().getUserById(CacheMemory.getInstance().getCurrentUserId());
        Preferences userPreferences = PreferencesRepository.getInstance().getPreferencesById(CacheMemory.getInstance().getCurrentUserId());
        User targetUser = UserRepository.getInstance().getUserById(UserToPreferencesRepository.getInstance().getUserIdByPreferencesId(targetPreferences.getPreferencesId()));
        // Retrieve the current user's preferences from CacheMemory
        Preferences currentUserPreferences = PreferencesRepository.getInstance().getPreferencesById(CacheMemory.getInstance().getCurrentUserId());

        // Calculate similarity score based on preferences
        // You can assign weights to different preferences
        // For example, preferences like age range, distance, and hobbies may have different weights

        // Age range: Calculate the absolute difference between the current user's age and the potential match's age preference,
        // as well as the absolute difference between the current user's age and the potential match's actual age
        int currentUserAge = calculateAge(currentUser.getDateOfBirth());
        int targetMinAge = targetPreferences.getMinAge();
        int targetMaxAge = targetPreferences.getMaxAge();
        int ageScore = 0;
        if (currentUserAge >= targetMinAge && currentUserAge <= targetMaxAge) {
            ageScore += PreferencesRepository.AGE_WEIGHT; // Give a score if the current user's age falls within the target age range preference
        }
        int targetAge = calculateAge(targetUser.getDateOfBirth());
        int ageDifference = Math.abs(currentUserAge - targetAge);
        ageScore += (PreferencesRepository.MAX_AGE_DIFFERENCE - ageDifference) * PreferencesRepository.AGE_DIFFERENCE_WEIGHT;

        // Distance: Calculate the absolute difference between distances and subtract from a maximum score
        int currentUserDistance = currentUserPreferences.getDistance();
        int targetDistance = targetPreferences.getDistance();
        int distanceDifference = Math.abs(currentUserDistance - targetDistance);
        int distanceScore = (PreferencesRepository.MAX_DISTANCE_DIFFERENCE - distanceDifference) * PreferencesRepository.DISTANCE_WEIGHT;

        // Hobbies: Check if both users share any hobbies and for every common hobby, increment score
        int hobbiesScore = 0;
        String[] userHobbies = currentUserPreferences.getHobbies().split(",");
        String[] targetHobbies = targetPreferences.getHobbies().split(",");
        for (String userHobby : userHobbies) {
            for (String targetHobby : targetHobbies) {
                if (userHobby.trim().equalsIgnoreCase(targetHobby.trim())) {
                    hobbiesScore += PreferencesRepository.HOBBIES_SCORE;
                    break;
                }
            }
        }

        // Gender: Check if the potential match's gender matches the current user's gender preference
        int genderScore = 0;
        Genders targetGender = targetUser.getGender();
        List<Genders> currentUserGenderPreference = currentUserPreferences.getGenders();
        for(Genders gender: currentUserGenderPreference) {
            if (targetGender == gender) {
                genderScore = PreferencesRepository.GENDER_SCORE;
                break;
            }
        }

        // Total similarity score
        similarityScore = ageScore + distanceScore + hobbiesScore + genderScore;

        return similarityScore;
    }

    // Helper method to calculate age from date of birth
    private int calculateAge(String dateOfBirthString) {
        // Parse the date of birth string into a LocalDate object
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString, formatter);

        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Calculate the period between the date of birth and the current date
        Period period = Period.between(dateOfBirth, currentDate);

        // Return the age
        return period.getYears();
    }

}

public class MatchingModel {
    private MatchingView matchingView;

    public MatchingModel(MatchingView matchingView) {
        this.matchingView = matchingView;
    }

    public List<User> getPotentialMatches() {
        List<User> allUsers = UserRepository.getInstance().getAllUsers();
        allUsers.removeIf(user -> user.getUserId() == CacheMemory.getInstance().getCurrentUserId()); // Remove the current user from the list of potential matches
        allUsers.sort(new SimilarityComparator()); // Sort the list of potential matches based on similarity score
        // after implementing matches, remove users that are already matched and users that have been swiped left
        return allUsers;
    }

    public void swipeRight(int userId) {
        // Add the user to the list of matches
//        CacheMemory.getInstance().addMatch(userId);
    }

    public void swipeLeft(int userId) {
        // Add the user to the list of swiped left users
    }
}
