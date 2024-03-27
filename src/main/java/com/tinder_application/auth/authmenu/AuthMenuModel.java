package com.tinder_application.auth.authmenu;

import com.tinder_application.helpers.PrintersAndFormatters;

class AuthMenuModel {
    private AuthMenu authMenu;

    public AuthMenuModel(AuthMenu authMenu) {
        this.authMenu = authMenu;
    }

    public void handleExit() {
        PrintersAndFormatters.getInstance().showMessage("Exiting...");
        System.out.println("See you again, pookie!");
    }
}
