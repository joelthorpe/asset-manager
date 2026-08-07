package com.joelthorpe.assetmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Initialise application components before starting the main loop
        Scanner input = new Scanner(System.in);
        AssetManager manager = new AssetManager();
        boolean isRunning = true;

        System.out.println("Welcome to the Asset Management System!");

        // Main application loop
        while (isRunning) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new asset");
            System.out.println("2. Display all assets");
            System.out.println("3. Find an asset by ID");
            System.out.println("4. Remove an asset");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice (1-5): ");

            String choice = input.nextLine();

            // Process the selected menu option
            switch (choice) {
                case "1":
                    int id = InputUtils.readInt(input, "Enter Asset ID: ");
                    String name = InputUtils.readString(input, "Enter Asset Name: ");
                    String category = InputUtils.readString(input, "Enter Asset Category (e.g. Laptop, Server):  ");
                    boolean isOnline = InputUtils.readBoolean(input, "Is it currently online? (true/false): ");

                    HardwareAsset newAsset = new HardwareAsset(id, name, category, isOnline);
                    manager.addAsset(newAsset);
                    break;

                case "2":
                    manager.displayAllAssets();
                    break;

                case "3":
                    int searchId = InputUtils.readInt(input, "Enter the ID of the asset to find: ");
                    HardwareAsset foundAsset = manager.findAssetById(searchId);

                    if (foundAsset != null) {
                        System.out.println("Asset Found: " + foundAsset.toString());
                    } else {
                        System.out.println("No asset found with ID: " + searchId);
                    }
                    break;

                case "4":
                    int removeId = InputUtils.readInt(input, "Enter the ID of the asset to remove: ");
                    manager.removeAsset(removeId);
                    break;

                case "5":
                    System.out.println("Exiting the system. Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please select an option between 1 and 5.");
            }
        }
        input.close();
    }
}
