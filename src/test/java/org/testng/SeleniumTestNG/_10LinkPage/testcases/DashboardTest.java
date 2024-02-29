package org.testng.SeleniumTestNG._10LinkPage.testcases;

import org.testng.SeleniumTestNG._10LinkPage.pages.CustomersPage;
import org.testng.SeleniumTestNG._10LinkPage.pages.DashboardPage;
import org.testng.SeleniumTestNG._10LinkPage.pages.LoginPage;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

public class DashboardTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CustomersPage customersPage;
    @Test
    public void testOpenCustomerPage(){
        //Login
        loginPage = new LoginPage(driver);
        dashboardPage = loginPage.loginCRM("admin@example.com","123456");

        //Click menu Customer
        customersPage = dashboardPage.clickMenuCustomer();//Xảy ra chuyển trang

        //Navigate Customerpage
        customersPage.clickButtonAddNew();
    }
}
