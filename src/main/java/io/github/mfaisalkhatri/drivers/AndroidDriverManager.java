package io.github.mfaisalkhatri.drivers;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import lombok.Builder;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
@Builder
public class AndroidDriverManager {

    public Platform platform;
    public String   platformVersion;

    private  AndroidDriver driver;

    public AndroidDriverManager createAndroidDriver () {
        try {
            driver = new AndroidDriver (new URL ("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities ());
            setupDriverTimeouts ();
        } catch (MalformedURLException e) {
            throw new RuntimeException (e);
        }
        return this;
    }

    public AndroidDriver getDriver () {
        return driver;
    }

    public void quitDriver () {
        driver.quit ();
    }

    private void setupDriverTimeouts () {
        getDriver ().manage ()
            .timeouts ()
            .implicitlyWait (30, TimeUnit.SECONDS);
    }

    private DesiredCapabilities capabilities () {

        DesiredCapabilities capabilities = new DesiredCapabilities ();
        capabilities.setCapability ("pCloudy_Username", System.getenv ("username"));
        capabilities.setCapability ("pCloudy_ApiKey", System.getenv ("apikey"));
        capabilities.setCapability ("pCloudy_DurationInMinutes", 10);
        capabilities.setCapability ("newCommandTimeout", 600);
        capabilities.setCapability ("launchTimeout", 90000);
        capabilities.setCapability ("pCloudy_DeviceFullName", "GOOGLE_Pixel3_Android_12.0.0_a6091");
        capabilities.setCapability ("platformVersion", platformVersion);
        capabilities.setCapability ("platformName", platform);
        capabilities.setCapability ("automationName", "uiautomator2");
        capabilities.setCapability ("pCloudy_ApplicationName", "pCloudy_Appium_Demo_Followme1675157898.apk");
        capabilities.setCapability ("appPackage", "com.pcloudy.appiumdemo");
        capabilities.setCapability ("appActivity", "com.ba.mobile.LaunchActivity");
        capabilities.setCapability ("pCloudy_WildNet", "false");
        capabilities.setCapability ("pCloudy_EnableVideo", "true");
        capabilities.setCapability ("pCloudy_EnablePerformanceData", "false");
        capabilities.setCapability ("pCloudy_EnableDeviceLogs", "true");
        return capabilities;
    }
}
