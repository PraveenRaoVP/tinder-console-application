package com.tinder_application.MainMenu;

import com.tinder_application.auth.authmenu.AuthMenu;
import com.tinder_application.repository.CacheMemory;
import com.tinder_application.repository.UserRepository;
import com.tinder_application.settings.SettingsView;

import java.util.Scanner;

public class MainMenuView {
    private final MainMenuModel mainMenuModel;

    public MainMenuView() {
        mainMenuModel = new MainMenuModel(this);
    }

    public void init() {
        System.out.println("Welcome, " + UserRepository.getInstance().getUserById(CacheMemory.getInstance().getCurrentUserId()).getUserName()+"!");
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            showMainMenu();
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    // TODO: Implement show people
                    System.out.println("Show people not implemented yet.");
                    break;
                case 2:
                    // TODO: Implement show matches
                    System.out.println("Show matches not implemented yet.");
                    break;
                case 3:
                    // TODO: Implement messages
                    System.out.println("Messages not implemented yet.");
                    break;
                case 4:
                    SettingsView settingsView = new SettingsView();
                    settingsView.settingsMenu();

                    break;
                case 5:
                    CacheMemory.getInstance().handleExit(); // to be implemented
                    CacheMemory.getInstance().setCurrentUserId(0);
                    System.out.println("Logged out successfully.");
                    AuthMenu authMenu = new AuthMenu();
                    authMenu.init();
                    break;
                case 6:
                    CacheMemory.getInstance().handleExit(); // to be implemented
                    System.exit(0);
            }
        } while(choice!=6);
    }

    public void showMainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Show People");
        System.out.println("2. Show Matches");
        System.out.println("3. Messages");
        System.out.println("4. Settings");
        System.out.println("5. Logout");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
    }
}
