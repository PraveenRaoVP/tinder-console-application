package com.tinder_application.auth.register;

import com.tinder_application.auth.authmenu.AuthMenu;
import com.tinder_application.helpers.ValidationUtils;
import com.tinder_application.models.enums.Genders;

import java.util.ArrayList;
import java.util.List;
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

    protected void getPreferences(int userId) {
        Scanner sc = new Scanner(System.in);
        int minAge, maxAge;
        do {
            System.out.println("Enter the minimum age preference: ");
            minAge = sc.nextInt();
            if(!ValidationUtils.getInstance().isValidMinAge(minAge)) {
                System.out.println("What is wrong with you?");
            } else break;
        } while(true);
        do {
            System.out.println("Enter the maximum age preference: ");
            maxAge = sc.nextInt();
            if(!ValidationUtils.getInstance().isValidMaxAge(maxAge)) {
                System.out.println("Yaaru saami nee.");
            } else break;
        } while(true);
        System.out.println("Enter the distance preference: ");
        int distance = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the hobbies: (comma separated)");
        String hobbies = sc.nextLine();
        System.out.println("Keep Entering Your Gender Preferences. Press 0 to stop.");
        int ch;
        List<Genders> gendersList = new ArrayList<>();
        do {
          System.out.println("Select Your Gender Preferences:-");
          System.out.println("1. Male");
          System.out.println("2. Female");
          System.out.println("3. Other");
          ch = sc.nextInt();
          switch (ch) {
              case 1:
                  gendersList.add(Genders.MALE);
                  break;
              case 2:
                  gendersList.add(Genders.FEMALE);
                  break;
              case 3:
                  gendersList.add(Genders.OTHER);
                  break;
              default:
                  break;
          }
        } while(ch!=0);
        registerModel.registerUserPreferences(userId, minAge, maxAge, distance, hobbies, gendersList);
    }

    protected void getPersonalDetails(int credId) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = sc.nextLine();
        String dob;
        do {
            System.out.println("Enter your date of birth: ");
            dob = sc.nextLine();
            if(!ValidationUtils.getInstance().isValidDate(dob)) {
                System.out.println("Invalid Date. Please try again.");
            } else break;
        } while(true);
        System.out.println("Enter your bio: ");
        String bio = sc.nextLine();
        System.out.println("Enter your height: ");
        String height = sc.nextLine();
        System.out.println("Enter the languages you know: (comma separated)");
        String languages = sc.nextLine();
        System.out.println("Enter your location: ");
        String location = sc.nextLine();
        System.out.println("Select Your Gender: ");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.println("3. Other");
        int ch = sc.nextInt();
        registerModel.registerUserPersonalDetails(credId, userName, dob, bio, height, languages, location, ch);
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

    public void completeRegistrationProcess() {
        System.out.println("Registration Successful!");
        AuthMenu authMenu = new AuthMenu();
        authMenu.init();
    }
}
