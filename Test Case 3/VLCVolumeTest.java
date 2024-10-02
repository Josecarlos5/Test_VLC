
package com.example;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class VLCVolumeTest {

    private static WindowsDriver driver = null;
    private Robot robot;

    @BeforeClass
    public void setUp() throws MalformedURLException, AWTException {
        // Set the desired capabilities for VLC
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe");  // Change to the correct VLC path
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");

        // Initialize WinAppDriver session
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Initialize Robot for keyboard control
        robot = new Robot();
    }

    @Test
    public void verifyVolumeControl() throws InterruptedException {
        // Focus VLC window
        Thread.sleep(3000);  // Wait for VLC to load fully

        // Increase volume to max (Ctrl + Up Arrow in a loop)
        System.out.println("Setting volume to maximum...");
        for (int i = 0; i < 20; i++) {  // Assume 20 key presses will set volume to max
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_UP);
            robot.keyRelease(KeyEvent.VK_UP);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(100);  // Small delay between key presses
        }

        // Now, reduce volume to 50% (Ctrl + Down Arrow)
        System.out.println("Setting volume to 50%...");
        for (int i = 0; i < 10; i++) {  // Adjust as needed to approximate 50% volume
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(100);
        }

        // Wait for a longer time to manually confirm volume is 50%
        System.out.println("Waiting for 30 seconds to manually verify the volume...");
        Thread.sleep(30000);  // Wait for 30 seconds

        // Optionally, you can add code to play a media file and confirm the volume level.
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
