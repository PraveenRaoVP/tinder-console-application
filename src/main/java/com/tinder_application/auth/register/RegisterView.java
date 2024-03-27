package com.tinder_application.auth.register;

import com.tinder_application.helpers.ValidationUtils;

import java.util.Scanner;

public class RegisterView {
    private RegisterModel registerModel;

    public RegisterView() {
        registerModel = new RegisterModel(this);
    }

    public void init() {
        getAllDetails();
    }

    public void getAllDetails() {
        getUserAuthDetails();
        registerModel.completeRegistration();
    }

    private void getPreferences() {
    }

    protected void getPersonalDetails(int credId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = sc.nextLine();
        System.out.println("Enter your date of birth: ");
        String dob = sc.nextLine();
        System.out.println("Enter your bio: ");
        String bio = sc.nextLine();
        System.out.println("Enter your height: ");
        String height = sc.nextLine();
    }

    protected void getUserAuthDetails() {
        Scanner sc = new Scanner(System.in);
        String email;
        String password;
        do {
            System.out.println("Enter your email: ");
            email = sc.nextLine();
            if(!ValidationUtils.getInstance().isValidEmail(email)) {
                System.out.println("Invalid Email. Please try again.");
            } else break;
        } while(true);
        do {
            System.out.println("Enter your password: ");
            password = sc.nextLine();
            System.out.println("Re-enter your password: ");
            String rePassword = sc.nextLine();
            if(!password.equals(rePassword)) {
                System.out.println("Passwords do not match. Please try again.");
            } else if(!ValidationUtils.getInstance().returnIsValidPassword(password)) {
                System.out.println("Password is too short. Please try again.");
            } else break;
        } while(true);
        registerModel.registerUserAuth(email, password);
    }
}
