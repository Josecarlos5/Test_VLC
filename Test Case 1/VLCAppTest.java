package com.example;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class VLCAppTest {
    private static WindowsDriver driver = null;  // No generic types here

    @BeforeClass
    public void setUp() throws MalformedURLException {
        // Set the desired capabilities for VLC
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Program Files (x86)\\VideoLAN\\VLC\\vlc.exe");  // Correct VLC path
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("deviceName", "WindowsPC");

        // Initialize WinAppDriver session
        driver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void verifyVLCAppLaunch() {
        // Verify if the VLC main window is displayed
        String mainWindowHandle = driver.getWindowHandle();
        Assert.assertNotNull(mainWindowHandle, "VLC main window is not displayed");
    }

    @AfterClass
    public void tearDown() {
        // Quit the driver
        if (driver != null) {
            driver.quit();
        }
    }
}
