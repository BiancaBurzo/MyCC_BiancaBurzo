package tests;

import base.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.DashboardPage;
import pages.LoginPage;
//import pages.SecureAreaPage;

import static org.testng.Assert.assertTrue;

import static utils.Timers.getDurationInMillisFrom;
import static utils.Timers.setTimestamp;

@Slf4j
public class LoginTests extends BaseTest {
	
    private static final String mail = "cctestuser4@yopmail.com";
	private static final String user = "CCTest@2021";

	@Test(groups = "end2end")
    @Parameters({mail, user})
    public void testSuccessfulLogin(String mail, String password){
    	
    	//Start timer
        setTimestamp("testSuccessfulLogin");
        
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setEmail(mail);
        Reporter.log("Enter email adress: " + mail);
        log.debug("Once before all tests within this class");
        loginPage.setPassword(password);
        Reporter.log("Enter password: " + password);
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        dashboardPage.getAlertText();
        
        assertTrue(dashboardPage.getAlertText()
                        .contains("You logged into a secure area!")
                , "Alert text is incorrect"); 
        //Report duration
        Reporter.log("Test duration: " + getDurationInMillisFrom("testSuccessfulLogin") + " ms");
        
        //Log duration
        log.debug(Long.toString(getDurationInMillisFrom("testSuccessfulLogin")));
        System.out.println(getDurationInMillisFrom("testSuccessfulLogin"));
        long maxDuration = 2000L;
        
        assertTrue(maxDuration >= getDurationInMillisFrom("testSuccessfulLogin"));
    }

    @Test(groups = "end2end")
    public void testSuccessfulLogin1() throws InterruptedException {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setEmail("cctestuser4@yopmail.com");
        loginPage.setPassword("CCTest@2021");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        dashboardPage.getAlertText();
        assertTrue(dashboardPage.getAlertText()
                        .contains("You logged into a secure area!")
                , "Alert text is incorrect");
    }

    @Test(groups = "end2end")
    public void testSuccessfulLogin2() throws InterruptedException {
        LoginPage loginPage = homePage.clickFormAuthentication();
        loginPage.setEmail("cctestuser4@yopmail.com");
        loginPage.setPassword("CCTest@2021");
        DashboardPage dashboardPage = loginPage.clickLoginButton();
        dashboardPage.getAlertText();
        assertTrue(dashboardPage.getAlertText()
                        .contains("You logged into a secure area!")
                , "Alert text is incorrect");
    }
}
