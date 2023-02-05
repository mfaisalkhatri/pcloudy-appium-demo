package io.github.mfaisalkhatri.pages.android;

import io.appium.java_client.MobileBy;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.WebElement;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
public class SearchFlightPage {

    private AndroidDriverManager androidDriverManager;

    public SearchFlightPage (AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    private WebElement searchFlightBtn () {
        return androidDriverManager.getDriver ()
            .findElement (MobileBy.id ("com.pcloudy.appiumdemo:id/searchFlights"));
    }

    public boolean isSearchFlightButtonDisplayed () {
        return searchFlightBtn ().isDisplayed ();
    }

}
