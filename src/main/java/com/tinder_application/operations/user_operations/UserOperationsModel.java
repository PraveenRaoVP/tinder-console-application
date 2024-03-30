package com.tinder_application.operations.user_operations;

import com.tinder_application.helpers.PrintersAndFormatters;
import com.tinder_application.models.Credentials;
import com.tinder_application.models.Preferences;
import com.tinder_application.models.User;
import com.tinder_application.repository.*;

public class UserOperationsModel {
    private UserOperationsView userOperationsView;

    public UserOperationsModel(UserOperationsView userOperationsView) {
        this.userOperationsView = userOperationsView;
    }

    public User getUser() {
        UserRepository.getInstance().pullDataFromJSON();
        UserToPreferencesRepository.getInstance().pullDataFromJSON();
        CredentialsRepository.getInstance().pullDataFromJSON();
        UserToCredentialsRepository.getInstance().pullDataFromJSON();
        PreferencesRepository.getInstance().pullDataFromJSON();
        User currentUser = UserRepository.getInstance().getUserById(CacheMemory.getInstance().getCurrentUserId());
        return currentUser;
    }

    public Preferences getPreferences() {
        int prefId = UserToPreferencesRepository.getInstance().getPreferencesIdByUserId(CacheMemory.getInstance().getCurrentUserId());
        return PreferencesRepository.getInstance().getPreferencesById(prefId);
    }

    public void changeName(String newName) {
        User currentUser = getUser();
        currentUser.setUserName(newName);
        UserRepository.getInstance().updateUser(currentUser);
        PrintersAndFormatters.showMessage("Updating name...");
        UserRepository.getInstance().pushDataToJSON();
        PrintersAndFormatters.showMessage("Name updated successfully.");
    }

    public boolean checkPassword(String oldPassword) {
        int credId = UserToCredentialsRepository.getInstance().getCredIdByUserId(CacheMemory.getInstance().getCurrentUserId());
        Credentials credentials = CredentialsRepository.getInstance().getCredentialsById(credId);
        return credentials.getPassword().equals(oldPassword);
    }

    public void changePassword(String newPassword) {
        int credId = UserToCredentialsRepository.getInstance().getCredIdByUserId(CacheMemory.getInstance().getCurrentUserId());
        Credentials credentials = CredentialsRepository.getInstance().getCredentialsById(credId);
        credentials.setPassword(newPassword);
        CredentialsRepository.getInstance().updateCredentials(credentials);
        PrintersAndFormatters.showMessage("Updating password...");
        CredentialsRepository.getInstance().pushDataToJSON();
        PrintersAndFormatters.showMessage("Password updated successfully.");
    }

    public void updateBio(String newBio) {
        User currentUser = getUser();
        currentUser.setBio(newBio);
        UserRepository.getInstance().updateUser(currentUser);
        PrintersAndFormatters.showMessage("Updating bio...");
        UserRepository.getInstance().pushDataToJSON();
        PrintersAndFormatters.showMessage("Bio updated successfully.");
    }
}
