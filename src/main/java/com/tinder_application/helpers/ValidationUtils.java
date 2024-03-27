package com.tinder_application.helpers;

public class ValidationUtils {
    private static ValidationUtils instance;

    private ValidationUtils() {}

    public static ValidationUtils getInstance() {
        if (instance == null) {
            instance = new ValidationUtils();
        }
        return instance;
    }

    public boolean isValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

    public boolean returnIsValidPassword(String password) {
        return password.length() >= 8;
    }

    public boolean isValidMinAge(int age) {
        return age >= 18;
    }

    public boolean isValidMaxAge(int maxAge) {
        return maxAge > 100;
    }
}
