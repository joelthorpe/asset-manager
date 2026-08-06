package com.joelthorpe.assetmanager;

public class HardwareAsset {
    // Private fields for encapsulation
    private int id;
    private String name;
    private String category;
    private boolean isOnline;

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
