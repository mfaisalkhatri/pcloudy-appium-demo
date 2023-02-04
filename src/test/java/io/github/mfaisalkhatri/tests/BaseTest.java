package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;
import org.openqa.selenium.Platform;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
public class BaseTest {

    protected AndroidDriverManager androidDriverManager;
    protected IOSDriverManager     iosDriverManager;

    @BeforeClass (alwaysRun = true)
    @Parameters ({ "platformName", "platformVersion" })
    public void testSetup (Platform platformName, String platformVersion) {
        if (platformName.is (Platform.ANDROID)) {
            androidDriverManager = AndroidDriverManager.builder ()
                .platform (platformName)
                .platformVersion (platformVersion)
                .build ()
                .createAndroidDriver ();
        } else if (platformName.is (Platform.IOS)) {
            iosDriverManager = IOSDriverManager.builder ()
                .platform (platformName)
                .platformVersion (platformVersion)
                .build ()
                .createIOSDriver ();
        }

    }

    @AfterClass (alwaysRun = true)
    public void tearDown () {
        if(androidDriverManager!=null) {
            androidDriverManager.quitDriver ();
        } else {
            iosDriverManager.quitDriver ();
        }


    }
}
