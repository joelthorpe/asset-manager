# Asset Management System

A Java-based command-line interface (CLI) application for managing IT hardware assets. This project was built to demonstrate Object-Oriented Programming (OOP) principles, encapsulation, and collection management using Java.

## Features
* **Add Assets:** Register new hardware assets (e.g. laptops, servers) with details such as ID, category, and online/offline status.
* **View Catalogue:** Display all currently tracked hardware assets.
* **Find Assets:** Locate specific assets using their unique ID.
* **Update Assets:** Modify the name, category, and online/offline status of an existing hardware asset using its unique ID.
* **Remove Assets:** Remove hardware assets from the catalogue using their unique ID.
* **Data Persistence:** Automatically save and load the hardware asset catalogue using a CSV file.

## Concepts Demonstrated
* Object-Oriented Programming (OOP)
* Encapsulation using private fields and getters/setters
* Classes, objects, and constructors
* ArrayList collection management
* File I/O operations (reading and writing to CSV)
* Methods and modular code structure
* Console-based user interaction

## Project Structure
The application is separated into five classes, with each class responsible for a specific part of the system:

```text
src/
└── com.joelthorpe.assetmanager/
    ├── Main.java
    ├── AssetManager.java
    ├── HardwareAsset.java
    ├── InputUtils.java
    └── StorageManager.java
```
* **`Main.java`** - Handles the main menu and user interaction.
* **`AssetManager.java`** - Manages the collection of hardware assets and provides add, find, update, display, and remove functionality.
* **`HardwareAsset.java`** - Represents an individual hardware asset and stores its details.
* **`InputUtils.java`** - Provides reusable methods for validating console input.
* **`StorageManager.java`** - Handles file-based persistence for saving and loading hardware assets.

## Technologies Used
* Java
* IntelliJ IDEA
* Git / GitHub

## How to Run
1. Clone this repository.
2. Open the project in a Java IDE (like IntelliJ IDEA or Eclipse).
3. Run `Main.java` to start the interactive console menu.

## Future Improvements
- [x] Add input validation for user entries
- [x] Prevent duplicate asset IDs
- [x] Add asset update functionality
- [x] Add file-based data persistence
- [ ] Add database integration
- [ ] Add graphical user interface (GUI)