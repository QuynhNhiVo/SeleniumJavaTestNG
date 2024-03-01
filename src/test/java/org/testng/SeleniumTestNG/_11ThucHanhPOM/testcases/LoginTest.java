package org.testng.SeleniumTestNG._11ThucHanhPOM.testcases;

import org.testng.SeleniumTestNG._11ThucHanhPOM.pages.DashboardPage;
import org.testng.SeleniumTestNG._11ThucHanhPOM.pages.LoginPage;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.SeleniumTestNG.keywords.keywords.WebUI;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai báo đối tượng của LoginPage
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    @Parameters({"email", "password"})
    public void loginSuccess(String email, String password){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(email, password);
        waitForPageLoaded();
        loginPage.verifyLoginSuccess();
        WebUI.captureScreenImage("testLogin");
        dashboardPage.logOut();
    }
    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@email.com", "123456");
        waitForPageLoaded();
        WebUI.captureScreenImage("testLogin");
        loginPage.verifyLoginFail();
    }

    @Test
    public void testLoginWithPasswordlInvalid(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com", "12456");
        waitForPageLoaded();
        WebUI.captureScreenImage("testLogin");
        loginPage.verifyLoginFail();
    }
}
