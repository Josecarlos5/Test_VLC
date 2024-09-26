
# VLC Desktop App Automation Testing

This project demonstrates how to automate the VLC desktop app on Windows using **Appium Desktop**, **Java**, and **TestNG** for functional test cases.

## Test Cases

### 1. **Test Case: Verify VLC App Launch**
- **Objective:** Confirm that the VLC app launches successfully on Windows.
- **Steps:**
  1. Launch the VLC application.
  2. Verify that the VLC window is displayed.
- **Expected Result:** The VLC app should open successfully, and the main window should be displayed.

### 2. **Test Case: Verify Play Button Functionality**
- **Objective:** Confirm the 'Play' button works correctly when a media file is loaded in VLC.
- **Steps:**
  1. Load a media file in VLC.
  2. Click the 'Play' button.
  3. Verify that the media starts playing.
- **Expected Result:** Media should begin playing when the 'Play' button is clicked.

### 3. **Test Case: Verify Volume Control**
- **Objective:** Confirm volume control functionality works.
- **Steps:**
  1. Adjust the volume slider to 50%.
  2. Verify the volume change is reflected in VLC.
- **Expected Result:** The volume should be set to 50%.

## Tools and Frameworks

The following tools and frameworks are used in this project:
- **Java Development Kit (JDK):** Required for Java development.
- **Appium Desktop:** Tool for automating Windows apps like VLC.
- **Node.js & NPM:** Required to install and run Appium.
- **Maven:** Build tool for managing dependencies.
- **TestNG:** Testing framework for structuring and running tests.

## Project Setup

Follow these steps to set up and install the required tools and frameworks.

### 1. Install Java Development Kit (JDK)
- **Download:** [Oracle JDK Downloads](https://www.oracle.com/java/technologies/javase-downloads.html)
- **Installation:** Follow the on-screen instructions for your OS.
- **Verify Installation:**
  Open **Command Prompt** and run:
  ```cmd
  java -version

### 2. Install Java Development Kit (JDK)
- **Download:**  Node.js Official Website
- **Installation:** Follow the on-screen instructions for your OS.
- **Verify Installation:**
  Open **Command Prompt** and run:
  node -v
  npm -v

### 3. Install Appium Desktop
- **Download:**  Appium Desktop Releases
- **Installation:** Follow the on-screen instructions for your OS.
- Start Appium Server: Open Appium Desktop and click the Start Server button.

### 4. Install Maven (For Dependency Management)
- **Download:**  Maven Official Website
- **Installation:**  Follow the instructions on the Maven website.
- **Verify Installation:**
mvn -version


This `README.md` file provides a clear and concise summary of the test cases, the tools/frameworks used, and detailed instructions for setting up and running the tests without using bash commands.
