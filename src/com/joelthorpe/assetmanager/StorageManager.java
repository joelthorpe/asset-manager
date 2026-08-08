package com.joelthorpe.assetmanager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Handles file-based persistence for hardware assets.
 * Provides functionality to save and load assets from a .CSV file.
 */
public class StorageManager {

    // Private constructor to prevent instantiation of a utility class
    private StorageManager() {}

    /**
     * Saves a list of hardware assets to a specified file location.
     * @param assets        the list of hardware assets to save
     * @param filename      the name of the file to write to
     */
    public static void saveAssets(ArrayList<HardwareAsset> assets, String filename) {
        try {
            File file = new File(filename);

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);

            // Write CSV header
            bw.write("id,name,category,isOnline");
            bw.newLine();

            // Write each asset to the file
            for (HardwareAsset asset : assets) {
                String csvLine = String.format("%d,%s,%s,%b",
                        asset.getId(),
                        asset.getName(),
                        asset.getCategory(),
                        asset.isOnline()
                );
                bw.write(csvLine);
                bw.newLine();
            }

            bw.close();
            fw.close();
            System.out.println("Success: Catalogue saved to '" + filename + "'.");
        } catch (IOException ex) {
            System.out.println("Error: An issue occurred while saving to '" + filename + "'.");
            ex.printStackTrace();
        }
    }

    /**
     * Loads a list of hardware assets from a specified file location.
     * @param filename      the name of the file to read from
     * @return              an ArrayList of loaded hardware assets
     */
    public static ArrayList<HardwareAsset> loadAssets(String filename) {
        ArrayList<HardwareAsset> loadedAssets = new ArrayList<>();
        File file = new File(filename);

        // If the file doesn't exist, return an empty list
        if (!file.exists()) {
            return loadedAssets;
        }

        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine(); // Read the header row

            line = br.readLine();
            while (line != null) {
                if (validLine(line)) {
                    try {
                        String[] parts = line.split(",");

                        int id = Integer.parseInt(parts[0].trim());
                        String name = parts[1].trim();
                        String category = parts[2].trim();
                        boolean isOnline = Boolean.parseBoolean(parts[3].trim());

                        HardwareAsset asset = new HardwareAsset(id, name, category, isOnline);
                        loadedAssets.add(asset);
                    } catch (Exception ex) {
                        System.out.println("Error: Could not parse line: " + line);
                    }
                }
                // Read the next line
                line = br.readLine();
            }

            br.close();
            fr.close();
            System.out.println("Success: Catalogue loaded from '" + filename + "'.");
        } catch (IOException ex) {
            System.out.println("Error: An issue occurred while loading from '" + filename + "'.");
            ex.printStackTrace();
        }

        return loadedAssets;
    }

    /**
     * Validates that a line from the CSV file has the expected number of parts
     * @param line      the line to be validated
     * @return          true if valid, false otherwise
     */
    private static boolean validLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            return false;
        }
        String[] parts = line.split(",");

        // Expect 4 parts: id, name, category, isOnline
        return parts.length == 4;
    }
}
