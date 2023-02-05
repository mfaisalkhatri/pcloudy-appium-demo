package io.github.mfaisalkhatri.pages.ios;

import io.appium.java_client.MobileBy;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 2/5/2023
 **/
public class MainPage {

    private IOSDriverManager iosDriverManager;

    public MainPage (IOSDriverManager iosDriverManager) {
        this.iosDriverManager = iosDriverManager;
    }

    private WebElement skipBtn () {
        return iosDriverManager.getDriver ().findElement (MobileBy.iOSClassChain ("**/XCUIElementTypeButton[`label == \"Skip\"`]"));
    }

    private WebElement showAlertViewBtn() {
        return iosDriverManager.getDriver ().findElement (MobileBy.iOSClassChain ("**/XCUIElementTypeStaticText[`label == \"SHOW ALERT VIEW\"`]"));
    }

    public String getHelloText () {
        return iosDriverManager.getDriver ().findElement (MobileBy.AccessibilityId ("Hello")).getText ();
    }

    public String getAlertText () {
        return iosDriverManager.getDriver ().findElement (MobileBy.AccessibilityId ("This is an alert view")).getText ();
    }

    private WebElement dismissBtn () {
        return iosDriverManager.getDriver ().findElement (MobileBy.iOSNsPredicateString ("label == \"Dismiss\" AND name == \"Dismiss\" AND value == \"Dismiss\""));
    }

    public void showAlertMessage () {
        skipBtn ().click ();
        showAlertViewBtn ().click ();
    }

    public void dismissAlert () {
        dismissBtn ().click ();
    }



}
