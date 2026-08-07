package com.joelthorpe.assetmanager;

import java.util.ArrayList;

/**
 * Manages a collection of hardware assets.
 * Provides functionality for adding, finding, displaying, and removing assets.
 */
public class AssetManager {

    // Private ArrayList to store hardware assets
    private ArrayList<HardwareAsset> assetList;

    /**
     * Initialises an empty asset list when the manager is created.
     */
    public AssetManager() {
        this.assetList = new ArrayList<>();
    }

    /**
     * Adds a new asset to the collection if its ID is not already in use.
     * @param asset    the hardware asset to add
     * @return         true if the asset was added successfully, false if a duplicate ID exists
     */
    public boolean addAsset(HardwareAsset asset) {
        if (findAssetById(asset.getId()) != null) {
            System.out.println("Error: An asset with ID " + asset.getId() + " already exists in the catalogue.");
            return false;
        }

        assetList.add(asset);
        System.out.println("Success: Asset '" + asset.getName() + "' has been added to the catalogue.");
        return true;
    }

    /**
     * Displays all hardware assets currently stored in the collection.
     */
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

    /**
     * Finds an asset using its unique ID.
     * @param id    the ID of the asset to find
     * @return      the matching hardware asset, or null if no asset exists with that ID
     */
    public HardwareAsset findAssetById(int id) {
        for (HardwareAsset asset : assetList) {
            if (asset.getId() == id) {
                return asset;
            }
        }
        return null;
    }

    /**
     * Updates the details of an existing asset.
     * @param id            the ID of the asset to update
     * @param newName       the new name of the asset
     * @param newCategory   the new category of the asset
     * @param isOnline      the new online status
     * @return              true if updated successfully, false if the asset was not found
     */
    public boolean updateAsset(int id, String newName, String newCategory, boolean isOnline) {
        HardwareAsset assetToUpdate = findAssetById(id);

        if (assetToUpdate != null) {
            assetToUpdate.setName(newName);
            assetToUpdate.setCategory(newCategory);
            assetToUpdate.setOnline(isOnline);
            System.out.println("Success: Asset ID " + id + " has been updated.");
            return true;
        }

        System.out.println("Error: Could not find an asset with ID " + id + " to update.");
        return false;
    }

    /**
     * Removes an asset from the collection using its ID.
     * @param id        the ID of the asset to remove
     */
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
