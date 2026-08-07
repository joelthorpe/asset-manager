package com.joelthorpe.assetmanager;

import java.util.ArrayList;

public class AssetManager {

    // Private ArrayList to store hardware assets
    private ArrayList<HardwareAsset> assetList;

    // Constructor to initialise the empty list when the manager is created
    public AssetManager() {
        this.assetList = new ArrayList<>();
    }

    // Method to add a new asset to the list, preventing duplicate IDs
    public boolean addAsset(HardwareAsset asset) {
        // Check if an asset with this ID already exists
        if (findAssetById(asset.getId()) != null) {
            System.out.println("Error: An asset with ID " + asset.getId() + " already exists in the catalogue.");
            return false;
        }

        // If no duplicate is found, add the asset
        assetList.add(asset);
        System.out.println("Success: Asset '" + asset.getName() + "' has been added to the catalogue.");
        return true;
    }

    // Method to display all assets
    public void displayAllAssets() {
        if(assetList.isEmpty()) {
            System.out.println("The catalogue is currently empty.");
            return;
        }

        System.out.println("\n--- Asset Catalogue ---");
        for (HardwareAsset asset : assetList) {
            System.out.println(asset.toString());
        }
    }

    // Method to find an asset by its ID
    public HardwareAsset findAssetById(int id) {
        for (HardwareAsset asset : assetList) {
            if (asset.getId() == id) {
                return asset;
            }
        }
        return null; // Return null if asset is not found
    }

    // Method to remove an asset by its ID
    public void removeAsset(int id) {
        HardwareAsset assetToRemove = findAssetById(id);

        if (assetToRemove != null) {
            assetList.remove(assetToRemove);
            System.out.println("Success: Asset ID " + id + " has been removed");
        } else {
            System.out.println("Error: Could not find an asset with ID " + id + " to remove.");
        }
    }
}
