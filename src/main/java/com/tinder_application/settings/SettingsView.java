package com.tinder_application.settings;

public class SettingsView {
    private SettingsModel settingsModel;

    public SettingsView() {
        settingsModel = new SettingsModel(this);
    }

    public void settingsMenu() {
        System.out.println("Settings Menu");
        System.out.println("Select Your Option:-");
        System.out.println("1. View Profile");
        System.out.println("2. Change Name");
        System.out.println("3. Change Password");
        System.out.println("4. Update Bio");
        System.out.println("5. Update Preferences");
        System.out.println("6. Delete Account");
    }
}
