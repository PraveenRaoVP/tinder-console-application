package com.tinder_application.helpers;

public class PrintersAndFormatters {
    private static PrintersAndFormatters instance;
    private PrintersAndFormatters() {}

    public static PrintersAndFormatters getInstance() {
        if(instance == null) {
            instance = new PrintersAndFormatters();
        }
        return instance;
    }

    public static void showMessage(String message) {
        System.out.println(message);
    }

    public void starLine() {
        System.out.println("********************************");
    }

    public void dashLine() {
        System.out.println("--------------------------------");
    }

    public void dottedLine() {
        System.out.println(".................................");
    }
}
