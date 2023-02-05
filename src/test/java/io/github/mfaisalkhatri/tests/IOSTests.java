package io.github.mfaisalkhatri.tests;

import static org.testng.Assert.assertEquals;

import io.github.mfaisalkhatri.pages.ios.LoginPage;
import io.github.mfaisalkhatri.pages.ios.MainPage;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 2/5/2023
 **/
public class IOSTests extends BaseTest {

    @Test
    public void testLogin () {
        LoginPage loginPage = new LoginPage (iosDriverManager);
        MainPage mainPage = loginPage.performLogin ("test@testname.com", "testmunk");
        mainPage.showAlertMessage ();
        assertEquals (mainPage.getHelloText (), "Hello");
        assertEquals (mainPage.getAlertText (), "This is an alert view");
        mainPage.dismissAlert ();
    }

}
