package com.tinder_application.operations.credentials_operations;

import java.util.Scanner;

public class CredOperationsView {
    private CredOperationsModel credOperationsModel;

    public CredOperationsView() {
        this.credOperationsModel = new CredOperationsModel(this);
    }

    public void changePassword() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your old password: ");
        String oldPassword = sc.nextLine();
        if(!credOperationsModel.checkPassword(oldPassword)) {
            System.out.println("Incorrect Password");
            return;
        }
        System.out.println("Enter new password: ");
        String newPassword = sc.nextLine();
        System.out.println("Re-enter new password: ");
        String reEnteredPassword = sc.nextLine();
        if(!newPassword.equals(reEnteredPassword)) {
            System.out.println("Passwords do not match");
            return;
        }
        credOperationsModel.changePassword(newPassword);
    }
}
