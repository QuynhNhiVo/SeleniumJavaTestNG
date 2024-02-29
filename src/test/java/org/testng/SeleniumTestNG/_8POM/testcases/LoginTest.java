package org.testng.SeleniumTestNG._8POM.testcases;

import org.testng.SeleniumTestNG._8POM.pages.LoginPage;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    //Khai báo đối tượng của LoginPage
    LoginPage loginPage;

    @Test
    public void loginSuccess(){
        loginPage = new LoginPage(driver);

        //Gọi hàm xử lý có sẳn để sử dụng
        loginPage.loginCRM("admin@example.com", "123456");
        waitForPageLoaded();//dùng khi chuyển trang
        loginPage.verifyLoginSuccess();
    }

    @Test
    public void testLoginWithEmailInvalid(){
        loginPage = new LoginPage(driver);

        loginPage.loginCRM("admin@email.com", "123456");
        loginPage.verifyLoginFail();
    }
}
