package io.github.mfaisalkhatri.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.github.mfaisalkhatri.pages.android.HomePage;
import io.github.mfaisalkhatri.pages.android.LoginPage;
import io.github.mfaisalkhatri.pages.android.SearchFlightPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
public class AndroidTests extends BaseTest {

    private HomePage homePage;

    @BeforeClass
    public void setup () {
        homePage = new HomePage (androidDriverManager);
    }

    @Test
    public void testEndUserLicense () {
        String endUserLicenseText = "Terms and Conditions relating to the pCloudy Application  General By clicking on the \"Accept\" button, you are agreeing to be bound by these Terms and Conditions. Please review them carefully before giving your acceptance. This application (\"pCloudy Application\") is owned and operated by pCloudy.com, whose registered office is at #hird Floor, Nishvi Building, 2729, 16th Cross Rd, PWD Quarters, 1st Sector, HSR Layout, Bengaluru, Karnataka 560102. \"We\", \"Our\" and \"Us\" refers to pCloudy.  Data Protection Any personal information you supply to Us when you use the pcloudy Application will be used in accordance with Our Privacy Policy which can be viewed at http://www.pcloudy.com The plcoudy test Application allows you to access certain functionality available on the website. Such access will be governed by the pcloudy website user agreement which can be viewed at http://www.pcloudy.com.";
        assertEquals (homePage.endUserLicenseText (), endUserLicenseText);
        homePage.acceptLicense ();
    }

    @Test
    public void testLogin () {
        LoginPage loginPage = new LoginPage (androidDriverManager);
        loginPage.performLogin ("123556", "1545");
        SearchFlightPage searchFlightPage = new SearchFlightPage (androidDriverManager);
        assertTrue (searchFlightPage.isSearchFlightButtonDisplayed ());

    }
}

