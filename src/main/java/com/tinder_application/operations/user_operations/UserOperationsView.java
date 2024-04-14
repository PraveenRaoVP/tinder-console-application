package com.tinder_application.operations.user_operations;

import com.tinder_application.models.Preferences;
import com.tinder_application.models.User;
import com.tinder_application.models.enums.Genders;
import com.tinder_application.operations.credentials_operations.CredOperationsView;

import java.util.Scanner;

public class UserOperationsView {
    private UserOperationsModel userOperationsModel;

    public UserOperationsView() {
        this.userOperationsModel = new UserOperationsModel(this);
    }

    public void viewProfile() {
        User user = userOperationsModel.getUser();
        Preferences preferences = userOperationsModel.getPreferences();
        System.out.println("Name: " + user.getUserName() + " (" + user.getGender() + ")");
        System.out.println("Email Id: " + user.getEmailId());
        System.out.println("Date of Birth: " + user.getDateOfBirth());
        System.out.println("Bio: " + user.getBio());
        System.out.println("Height: " + user.getHeight());
        System.out.println("Languages Known: " + user.getLanguagesKnown());
        System.out.println("Preferences:");
        System.out.println("Minimum Age: " + preferences.getMinAge());
        System.out.println("Maximum Age: " + preferences.getMaxAge());
        System.out.println("Distance: " + preferences.getDistance());
        System.out.println("Hobbies: " + preferences.getHobbies());
        System.out.print("Genders: ");
        for(Genders gender: preferences.getGenders()) {
            System.out.print(gender+" ");
        }
        System.out.println();
    }


    public void changeName() {
        Scanner sc = new Scanner(System.in);
        User user = userOperationsModel.getUser();
        System.out.println("Your old name: " + user.getUserName());
        System.out.println("Enter new name: ");
        String newName = sc.nextLine();
        userOperationsModel.changeName(newName);
    }

    public void changePassword() {
        CredOperationsView credOperationsView = new CredOperationsView();
        credOperationsView.changePassword();
    }

    public void updateBio() {
        System.out.println("Your old bio: " + userOperationsModel.getUser().getBio());
        System.out.println("Enter your new bio: ");
        Scanner sc = new Scanner(System.in);
        String newBio = sc.nextLine();
        userOperationsModel.updateBio(newBio);
    }
}
