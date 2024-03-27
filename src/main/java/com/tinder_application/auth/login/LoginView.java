package com.tinder_application.auth.login;

import com.tinder_application.auth.authmenu.AuthMenu;
import com.tinder_application.repository.CacheMemory;

import java.util.Scanner;

public class LoginView {
    private LoginModel loginModel;

    public LoginView() {
        loginModel = new LoginModel(this);
    }

    public void init() {
        loginModel.handleLogin();
    }

    public void loginScreen() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your email: ");
        String email = sc.nextLine();
        System.out.println("Enter your password: ");
        String password = sc.nextLine();
        if (loginModel.authenticateUser(email, password)) {
            System.out.println("Login successful");
            System.exit(1);
        }
    }

    public void handleBackToMainMenu() {
        AuthMenu authMenu = new AuthMenu();
        authMenu.init();
    }
}
