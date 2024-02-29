package org.testng.SeleniumTestNG._11ThucHanhPOM.testcases;

import org.testng.SeleniumTestNG._11ThucHanhPOM.pages.CustomersPage;
import org.testng.SeleniumTestNG._11ThucHanhPOM.pages.DashboardPage;
import org.testng.SeleniumTestNG._11ThucHanhPOM.pages.LoginPage;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.SeleniumTestNG.keywords.constants.ConfigData;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testOpenCustomerPage(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.email,ConfigData.password);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.verifyHeaderCustomerPage();
    }

    @Test
    public void testAdminRole(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com","123456");
        loginPage.verifyLoginSuccess();
        dashboardPage.verifyMenuReportDisplay();
    }
//
//    @Test
//    public void testProjectRole(){
//        loginPage = new LoginPage(driver);
//        dashboardPage = loginPage.loginCRM("project@example.com","123456");
//        loginPage.verifyLoginSuccess();
//        dashboardPage.verifyMenuReportNotDisplay();
//    }
}
