package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.DashBoardPage;

import static org.testng.Assert.assertEquals;


public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfullogin () {
      /*  loginPage.setEmailField("interns@interns.com");
        loginPage.setPasswordField("interns");*/
       DashBoardPage dashboardpage =  loginPage.clickLoginButton();
       assertEquals(dashboardpage.getAlertText(),
               "Signed in successfully.", "Log in function is working");
    }
    }
