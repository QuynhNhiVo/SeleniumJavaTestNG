package org.testng.SeleniumTestNG._11ThucHanhPOM.testcases;

import org.testng.SeleniumTestNG._11ThucHanhPOM.pages.CustomersPage;
import org.testng.SeleniumTestNG._11ThucHanhPOM.pages.DashboardPage;
import org.testng.SeleniumTestNG._11ThucHanhPOM.pages.LoginPage;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.SeleniumTestNG.keywords.constants.ConfigData;
import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;

    @Test
    public void testAddNewCustomer(){
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM(ConfigData.email, ConfigData.password);
        loginPage.verifyLoginSuccess();

        customersPage = dashboardPage.clickMenuCustomer();
        customersPage.verifyHeaderCustomerPage();

        customersPage.clickButtonAddNew();

        String COMPANY_NAME = "1 F Test";
        customersPage.inputFromData(COMPANY_NAME);
        customersPage.searchAndVerifyCustomer(COMPANY_NAME);
        customersPage.verifyCustomerDetail(COMPANY_NAME);
    }
}
