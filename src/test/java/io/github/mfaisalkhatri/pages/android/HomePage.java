package io.github.mfaisalkhatri.pages.android;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
public class HomePage {

    private AndroidDriverManager androidDriverManager;

    public HomePage (AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    public String endUserLicenseText () {
        return androidDriverManager.getDriver ()
            .findElement (MobileBy.id ("com.pcloudy.appiumdemo:id/textView2"))
            .getText ();
    }

    private WebElement acceptLicenseBtn () {
        return  androidDriverManager.getDriver ()
            .findElement (MobileBy.id ("com.pcloudy.appiumdemo:id/accept"));
    }

    public void acceptLicense () {
        acceptLicenseBtn ().click ();
    }

    private WebElement loginBtn () {
        return androidDriverManager.getDriver ()
            .findElement (MobileBy.id ("com.pcloudy.appiumdemo:id/ecLoginButton"));
    }

    public void clickLoginBtn () {
        loginBtn ().click ();
    }
}
