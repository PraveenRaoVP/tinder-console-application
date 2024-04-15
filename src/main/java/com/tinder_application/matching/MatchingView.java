package com.tinder_application.matching;

import com.tinder_application.helpers.PrintersAndFormatters;
import com.tinder_application.models.User;
import com.tinder_application.repository.CacheMemory;
import com.tinder_application.repository.UserRepository;

import java.util.List;
import java.util.Scanner;

public class MatchingView {
    private MatchingModel matchingModel;

    public MatchingView() {
        matchingModel = new MatchingModel(this);
    }

    public void displayMatches() {
        // TODO: Implement undo feature in next version.
        Scanner sc = new Scanner(System.in);
        List<User> potentialMatches = matchingModel.getPotentialMatches();
        label: // label to break out of the loop
        for(User users: potentialMatches) {
            displayMatchDetails(users);
            System.out.println("Do you want to like this user? (y/n/e)");
            String choice = sc.nextLine();
            switch (choice) {
                case "y":
                    matchingModel.swipeRight(users.getUserId());
                    break;
                case "n":
                    matchingModel.swipeLeft(users.getUserId());
                    break;
                case "e":
                    break label; // exit the loop
                default: // if the user enters an invalid choice
                    System.out.println("Invalid choice. Disliking...");
                    break;
            }
        }
    }

    public void displayMatchDetails(User user) {
        PrintersAndFormatters.getInstance().starLine();
        System.out.println("Name: " + user.getUserName());
        System.out.println("Age: " + CacheMemory.getInstance().calculateAge(user.getDateOfBirth()));
        System.out.println("Gender: " + user.getGender());
        System.out.println("Bio: " + user.getBio());
        System.out.println("Height: " + user.getHeight());
        System.out.println("Languages: " + user.getLanguagesKnown());
        System.out.println("Location: " + user.getLocation());
        PrintersAndFormatters.getInstance().starLine();
    }

    public void matchMessage(int userId) {
        System.out.println("It's a match!!!");
        User user = UserRepository.getInstance().getUserById(CacheMemory.getInstance().getCurrentUserId());
        User target = UserRepository.getInstance().getUserById(userId);
        System.out.println(user.getUserName() + " ♡ " + target.getUserName() + " !");
    }
}
