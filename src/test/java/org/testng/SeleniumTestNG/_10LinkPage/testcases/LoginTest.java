package org.testng.SeleniumTestNG._10LinkPage.testcases;

import org.testng.SeleniumTestNG._10LinkPage.pages.DashboardPage;
import org.testng.SeleniumTestNG._10LinkPage.pages.LoginPage;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai báo đối tượng của LoginPage
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void loginSuccess(){
        loginPage = new LoginPage(driver);

        //Gọi hàm xử lý có sẳn để sử dụng
        dashboardPage = loginPage.loginCRM("admin@example.com", "123456");
//        dashboardPage = new DashboardPage(driver);
//        dashboardPage.logOut();

        waitForPageLoaded();//dùng khi chuyển trang
        loginPage.verifyLoginSuccess();

        //Logout từ trang dashboard
        dashboardPage.logOut();
    }

    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@email.com", "123456");
        loginPage.verifyLoginFail();
    }
}
