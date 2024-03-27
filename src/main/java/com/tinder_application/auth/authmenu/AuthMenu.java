package com.tinder_application.auth.authmenu;

import com.tinder_application.TinderApplication;
import com.tinder_application.auth.login.LoginView;
import com.tinder_application.auth.register.RegisterView;
import com.tinder_application.helpers.PrintersAndFormatters;

import java.util.Scanner;

public class AuthMenu {

    private AuthMenuModel authMenuModel;

    public AuthMenu() {
        authMenuModel = new AuthMenuModel(this);
    }

    public void init() {
        PrintersAndFormatters.getInstance().starLine();
        System.out.println("Welcome to " + TinderApplication.getInstance().getAppName() + "-v "+ TinderApplication.getInstance().getAppVersion());
        PrintersAndFormatters.getInstance().starLine();
        handleMenuInput();
    }

    public void handleMenuInput() {
        PrintersAndFormatters.getInstance().starLine();
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your choice: ");
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                LoginView loginView = new LoginView();
                loginView.init();
                break;
            case 2:
                RegisterView registerView = new RegisterView();
                registerView.init();
                break;
            case 3:
                authMenuModel.handleExit();
                System.exit(0);
                break;
        }
    }
}
