package io.github.mfaisalkhatri.tests;

import io.github.mfaisalkhatri.pages.android.HomePage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author Faisal Khatri
 * @since 2/4/2023
 **/
public class AndroidTests extends  BaseTest{

    private HomePage homePage;
    @BeforeClass
    public void setup() {
        homePage = new HomePage (androidDriverManager);
    }

    @Test
    public void testEndUserLicense(){
        //System.out.println (homePage.endUserLicenseText ());
        homePage.acceptLicense ();
    }
}
