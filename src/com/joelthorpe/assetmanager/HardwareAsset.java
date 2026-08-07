package com.joelthorpe.assetmanager;

/**
 * Represents a physical hardware asset in the IT system.
 * Stores details including ID, name, category, and online status.
 */
public class HardwareAsset {
    // Private fields for encapsulation
    private int id;
    private String name;
    private String category;
    private boolean isOnline;

    /**
     * Constructs a new HardwareAsset.
     * @param id        the unique identifier for the asset
     * @param name      the name or model of the hardware
     * @param category  the type of hardware (e.g. Laptop/Server)
     * @param isOnline  the current network status of the asset
     */
    public HardwareAsset(int id, String name, String category, boolean isOnline) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.isOnline = isOnline;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean isOnline) {
        this.isOnline = isOnline;
    }

    // Returns a string representation of the asset
    @Override
    public String toString() {
        String status = isOnline ? "Online" : "Offline";

        return String.format("ID: %d | Name: %s | Category: %s | Status: %s",
                id, name, category, status);
    }

}
