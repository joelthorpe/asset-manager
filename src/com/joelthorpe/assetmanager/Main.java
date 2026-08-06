package com.joelthorpe.assetmanager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create input handler and asset manager before starting the application loop
        Scanner input = new Scanner(System.in);
        AssetManager manager = new AssetManager();
        boolean isRunning = true;

        System.out.println("Welcome to the Asset Management System!");

        // Main application loop
        while (isRunning) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add a new Asset");
            System.out.println("2. Display all Assets");
            System.out.println("3. Find an Asset by ID");
            System.out.println("4. Remove an Asset");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice (1-5): ");

            String choice = input.nextLine();

            // Handle the user's menu choice and perform the requested operation
            switch (choice) {
                case "1":
                    System.out.print("Enter Asset ID: ");
                    int id = Integer.parseInt(input.nextLine());

                    System.out.print("Enter Asset Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Asset Category (e.g. Laptop, Server):  ");
                    String category = input.nextLine();

                    System.out.print("Is it currently online? (true/false): ");
                    boolean isOnline = Boolean.parseBoolean(input.nextLine());

                    HardwareAsset newAsset = new HardwareAsset(id, name, category, isOnline);
                    manager.addAsset(newAsset);
                    break;

                case "2":
                    manager.displayAllAssets();
                    break;

                case "3":
                    System.out.print("Enter the ID of the asset to find: ");
                    int searchId = Integer.parseInt(input.nextLine());
                    HardwareAsset foundAsset = manager.findAssetById(searchId);

                    if (foundAsset != null) {
                        System.out.println("Asset Found: " + foundAsset.toString());
                    } else {
                        System.out.println("No asset found with ID: " + searchId);
                    }
                    break;

                case "4":
                    System.out.print("Enter the ID of the asset to remove: ");
                    int removeId = Integer.parseInt(input.nextLine());
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
