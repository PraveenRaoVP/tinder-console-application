package com.tinder_application;

import com.tinder_application.auth.authmenu.AuthMenu;

public class TinderApplication {
    private static TinderApplication instance;

    private TinderApplication() {
    }

    public static TinderApplication getInstance() {
        if(instance == null) {
            instance = new TinderApplication();
        }
        return instance;
    }

    private static String appName = "Tinder Console Application.";
    private static String version = "0.0.1";

    public String getAppName() {
        return appName;
    }

    public String getAppVersion() {
        return version;
    }

    public void init(){
        AuthMenu authMenu = new AuthMenu();
        authMenu.init();
    }

    // Driver Code
    public static void main(String[] args) {
        TinderApplication.getInstance().init();
    }
}