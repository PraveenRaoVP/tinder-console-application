package com.tinder_application.auth.register;

import com.tinder_application.repository.CredentialsRepository;

class RegisterModel {
    private RegisterView registerView;

    public RegisterModel(RegisterView registerView) {
        this.registerView = registerView;
    }

    public void registerUserAuth(String email, String password) {
        // Register the user
        CredentialsRepository.getInstance().addCredentials(email, password);
        registerView.getPersonalDetails(CredentialsRepository.getInstance().getCredentialsByEmail(email).getCredId());
    }

    public void registerUserPersonalDetails(int credId) {

    }

    public void completeRegistration() {

    }
}
