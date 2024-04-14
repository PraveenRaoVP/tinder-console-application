package com.tinder_application.operations.credentials_operations;

import com.tinder_application.helpers.PrintersAndFormatters;
import com.tinder_application.models.Credentials;
import com.tinder_application.repository.CacheMemory;
import com.tinder_application.repository.CredentialsRepository;
import com.tinder_application.repository.UserToCredentialsRepository;

public class CredOperationsModel {
    private CredOperationsView credOperationsView;

    public CredOperationsModel(CredOperationsView credOperationsView) {
        this.credOperationsView = credOperationsView;
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

    public boolean checkPassword(String oldPassword) {
        int credId = UserToCredentialsRepository.getInstance().getCredIdByUserId(CacheMemory.getInstance().getCurrentUserId());
        Credentials credentials = CredentialsRepository.getInstance().getCredentialsById(credId);
        return credentials.getPassword().equals(oldPassword);
    }
}
