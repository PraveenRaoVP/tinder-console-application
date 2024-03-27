package com.tinder_application.auth.login;

import com.tinder_application.models.Credentials;
import com.tinder_application.helpers.PrintersAndFormatters;
import com.tinder_application.repository.CacheMemory;
import com.tinder_application.repository.CredentialsRepository;
import com.tinder_application.repository.UserToCredentialsRepository;

class LoginModel {
    private LoginView loginView;

    public LoginModel(LoginView loginView) {
        this.loginView = loginView;
    }

    public void handleLogin() {
        int attempts = 1;
        do {
            loginView.loginScreen();
        } while(attempts++ < 3);
        PrintersAndFormatters.showMessage("Maximum attempts reached. Going back to Main Menu...");
        loginView.handleBackToMainMenu();
    }

    public boolean authenticateUser(String email, String password) {
        Credentials credentials = CredentialsRepository.getInstance().getCredentialsByEmail(email);
        if(credentials == null) {
            PrintersAndFormatters.showMessage("Login Failed. User Not Found.");
            return false;
        } else {
            if(!credentials.getPassword().equals(password)) {
                PrintersAndFormatters.showMessage("Login Failed. Invalid Password.");
                return false;
            }
        }
        int userId = UserToCredentialsRepository.getInstance().getUserIdByCredId(credentials.getCredId());
        CacheMemory.getInstance().setCurrentUserId(userId);
        return true;
    }
}
