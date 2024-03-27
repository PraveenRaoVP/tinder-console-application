package com.tinder_application.auth.register;

import com.tinder_application.helpers.PrintersAndFormatters;
import com.tinder_application.models.Preferences;
import com.tinder_application.models.User;
import com.tinder_application.models.enums.Genders;
import com.tinder_application.repository.*;

import java.util.List;

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

    public void registerUserPersonalDetails(int credId, String userName, String dob, String bio, String height, String languages, String location,int genderChoice) {
        String emailId = CredentialsRepository.getInstance().getCredentialsById(credId).getEmail();
        Genders gender = switch (genderChoice) {
            case 1 -> Genders.MALE;
            case 2 -> Genders.FEMALE;
            default -> Genders.OTHER;
        };
        User user = UserRepository.getInstance().addUser(userName, emailId, dob, bio, height, languages, location, gender);
        UserToCredentialsRepository.getInstance().addUserToCredentials(user.getUserId(), credId);
        registerView.getPreferences(user.getUserId());
    }

    public void completeRegistration() {
        CredentialsRepository.getInstance().pushDataToJSON();
        UserRepository.getInstance().pushDataToJSON();
        UserToCredentialsRepository.getInstance().pushDataToJSON();
        PreferencesRepository.getInstance().pushDataToJSON();
        UserToPreferencesRepository.getInstance().pushDataToJSON();
    }

    public void registerUserPreferences(int userId, int minAge, int maxAge, int distance, String hobbies, List<Genders> gendersList) {
        Preferences preferences = PreferencesRepository.getInstance().addPreferences(userId, minAge, maxAge, distance, hobbies, gendersList);
        completeRegistration();
        registerView.completeRegistrationProcess();
    }
}
