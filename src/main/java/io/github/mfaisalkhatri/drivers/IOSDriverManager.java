package io.github.mfaisalkhatri.drivers;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.ios.IOSDriver;
import lombok.Builder;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
@Builder
public class IOSDriverManager {

    public Platform platform;
    public String   platformVersion;

    private IOSDriver driver;

    public IOSDriverManager createIOSDriver () {
        try {
            driver = new IOSDriver (new URL ("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities ());
        } catch (MalformedURLException e) {
            throw new RuntimeException (e);
        }
        return this;
    }

    public IOSDriver getDriver () {
        if (null != driver) {
            createIOSDriver ();
        }
        return driver;
    }

    public void quitDriver () {
        driver.quit ();
    }

    private DesiredCapabilities capabilities () {

        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("pCloudy_Username", System.getenv ("username"));
        capabilities.setCapability ("pCloudy_ApiKey", System.getenv ("apikey"));
        capabilities.setCapability ("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability ("newCommandTimeout", 600);
        capabilities.setCapability ("launchTimeout", 90000);
        capabilities.setCapability ("pCloudy_DeviceFullName", "APPLE_iPhone11ProMax_iOS_15.0.0_b99a8");
        capabilities.setCapability ("platformVersion", platformVersion);
        capabilities.setCapability ("platformName", platform);
        capabilities.setCapability ("automationName", "XCUITest");
        capabilities.setCapability ("pCloudy_ApplicationName", "pCloudy_Appium_Demo_Resigned1675160846.ipa");
        capabilities.setCapability ("appPackage", "com.pcloudy.appiumdemo");
        capabilities.setCapability ("appActivity", "com.ba.mobile.LaunchActivity");
        capabilities.setCapability ("pCloudy_WildNet", "false");
        capabilities.setCapability ("pCloudy_EnableVideo", "false");
        capabilities.setCapability ("pCloudy_EnablePerformanceData", "false");
        capabilities.setCapability ("pCloudy_EnableDeviceLogs", "false");
        return capabilities;
    }
}

