package com.pluralsight;

import com.pluralsight.data.DataManager;
import com.pluralsight.dealership.UserInterface;

public class Main {
    public static void main(String[] args) {
        String username = args[0];
        String password = args[1];

        DataManager dataManager = new DataManager("cardealership", username, password);

        UserInterface userInterface = new UserInterface(null);
        userInterface.display();

    }
}
