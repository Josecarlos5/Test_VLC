
package com.example;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class VLCPlayTest {

    private Robot robot;

    @BeforeClass
    public void setUp() throws AWTException {
        // Initialize Robot class for keyboard simulation
        robot = new Robot();

        // Open VLC by using Robot 
        Runtime runtime = Runtime.getRuntime();

        try {
            // Confirm VLC is installed at this location or adjust the path
            runtime.exec("C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe");

            Thread.sleep(2000);  // Give time to open VLC
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void verifyPlayButtonFunctionality() throws InterruptedException {
        // Simulate pressing Ctrl+O to open a media file in VLC
        System.out.println("Simulating Ctrl+O to open file...");
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_O);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);  // Wait for the dialog to open

        // Copy file path to the system clipboard
        String mediaPath = "C:\\Users\\jose.silva.couto\\Documents\\test cases\\1.mp4";
        StringSelection selection = new StringSelection(mediaPath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        
        // Simulate Ctrl+V to paste the file path
        System.out.println("Pasting the file path...");
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        Thread.sleep(1000);  // Wait for the file path to paste

        // Press Enter to load the file
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        Thread.sleep(2000);  // Wait for VLC to load the media file

        // Simulate pressing the spacebar to play/pause the media file
        System.out.println("Simulating spacebar press to play/pause the file...");
        robot.keyPress(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_SPACE);
        Thread.sleep(3000);  // Wait for the media to play

        System.out.println("Media should be playing now.");
    }

    @AfterClass
    public void tearDown() {
        // quit VLC 
        try {
            robot.keyPress(KeyEvent.VK_ALT);
            robot.keyPress(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_F4);
            robot.keyRelease(KeyEvent.VK_ALT);
            System.out.println("VLC closed.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
