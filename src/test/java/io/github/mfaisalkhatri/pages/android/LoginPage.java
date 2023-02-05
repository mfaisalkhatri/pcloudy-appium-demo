package io.github.mfaisalkhatri.pages.android;

import io.appium.java_client.MobileBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
public class LoginPage {

    private AndroidDriverManager androidDriverManager;

    public LoginPage (AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    private WebElement userNamefield () {
        return androidDriverManager.getDriver ()
            .findElement (MobileBy.id ("com.pcloudy.appiumdemo:id/username"));
    }

    private WebElement passwordField () {
        return androidDriverManager.getDriver ()
            .findElement (MobileBy.id ("com.pcloudy.appiumdemo:id/password"));
    }

    private WebElement loginBtn () {
        return androidDriverManager.getDriver ()
            .findElement (MobileBy.id ("com.pcloudy.appiumdemo:id/loginbtn"));
    }

    public void performLogin (String userName, String password) {
        HomePage homePage = new HomePage (androidDriverManager);
        homePage.clickLoginBtn ();
        userNamefield ().sendKeys (userName);
        passwordField ().sendKeys (password);
        loginBtn ().click ();
    }

}
