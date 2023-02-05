package io.github.mfaisalkhatri.pages.ios;

import io.appium.java_client.MobileBy;
import io.github.mfaisalkhatri.drivers.IOSDriverManager;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 2/5/2023
 **/
public class LoginPage {

    private IOSDriverManager iosDriverManager;

    public LoginPage (IOSDriverManager iosDriverManager) {
        this.iosDriverManager = iosDriverManager;
    }

    private WebElement emailField () {
        return iosDriverManager.getDriver ()
            .findElement (MobileBy.iOSNsPredicateString ("value == \"Email\""));
    }

    private WebElement passwordField () {
        return iosDriverManager.getDriver ()
            .findElement (MobileBy.iOSNsPredicateString ("value == \"Password\""));
    }

    private WebElement loginBtn () {
        return iosDriverManager.getDriver ()
            .findElement (MobileBy.iOSClassChain ("**/XCUIElementTypeButton[`label == \"SIGN IN\"`]"));
    }

    public MainPage performLogin (String userName, String password) {
        emailField ().sendKeys (userName);
        passwordField ().sendKeys (password);
        loginBtn ().click ();
        return new MainPage (iosDriverManager);
    }

}
