package io.github.mfaisalkhatri.pages.android;

import io.appium.java_client.MobileElement;
import io.github.mfaisalkhatri.drivers.AndroidDriverManager;
import org.openqa.selenium.By;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
public class SearchFlightPage {

    private AndroidDriverManager androidDriverManager;

    public SearchFlightPage (AndroidDriverManager androidDriverManager) {
        this.androidDriverManager = androidDriverManager;
    }

    private MobileElement searchFlightBtn () {
        return (MobileElement) androidDriverManager.getDriver ()
            .findElement (By.id ("com.pcloudy.appiumdemo:id/searchFlights"));
    }

    public boolean isSearchFlightButtonDisplayed () {
        return searchFlightBtn ().isDisplayed ();
    }

}
