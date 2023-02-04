package io.github.mfaisalkhatri.pages.android;

import io.appium.java_client.MobileElement;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
public class LoginPage {

    private AndroidDriverManager androidDriverManager;

    public LoginPage (AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    private MobileElement userNamefield () {
        return (MobileElement) androidDriverManager.getDriver ()
            .findElement (By.id ("com.pcloudy.appiumdemo:id/username"));
    }

    private MobileElement passwordField () {
        return (MobileElement) androidDriverManager.getDriver ()
            .findElement (By.id ("com.pcloudy.appiumdemo:id/password"));
    }

    private MobileElement loginBtn () {
        return (MobileElement) androidDriverManager.getDriver ()
            .findElement (By.id ("com.pcloudy.appiumdemo:id/loginbtn"));
    }

    public void performLogin (String userName, String password) {
        HomePage homePage = new HomePage (androidDriverManager);
        homePage.clickLoginBtn ();
        userNamefield ().sendKeys (userName);
        passwordField ().sendKeys (password);
        loginBtn ().click ();
    }

}
