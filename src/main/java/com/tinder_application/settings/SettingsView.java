package com.tinder_application.settings;

import com.tinder_application.operations.user_operations.UserOperationsView;

import java.util.Scanner;

public class SettingsView {
    private SettingsModel settingsModel;

    public SettingsView() {
        settingsModel = new SettingsModel(this);
    }

    public void settingsMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Settings Menu");
        System.out.println("Select Your Option:-");
        System.out.println("1. View Profile");
        System.out.println("2. Change Name");
        System.out.println("3. Change Password");
        System.out.println("4. Update Bio");
        System.out.println("5. Update Preferences");
        System.out.println("6. Delete Account");
        System.out.println("7. Back");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                UserOperationsView userOperationsView = new UserOperationsView();
                userOperationsView.viewProfile();
                break;
            case 2:
                userOperationsView = new UserOperationsView();
                userOperationsView.changeName();
                break;
            case 3:
                userOperationsView = new UserOperationsView();
                userOperationsView.changePassword();
                break;
            case 4:
                userOperationsView = new UserOperationsView();
                userOperationsView.updateBio();
                break;
            case 5:
                System.out.println("Update Preferences not implemented yet.");
                break;
            case 6:
                System.out.println("Delete Account not implemented yet.");
                break;
            case 7:
                break;
        }
    }
}
