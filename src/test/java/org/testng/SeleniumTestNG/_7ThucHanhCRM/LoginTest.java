package org.testng.SeleniumTestNG._7ThucHanhCRM;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.SeleniumTestNG.locator.LocatorCRM;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {
    @Test
    public void loginCRM(){

        driver.get("https://crm.anhtester.com/admin/clients");
        waitForPageLoaded();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Not Login Page");
        driver.findElement(By.xpath(LocatorCRM.email)).sendKeys(LocatorCRM.emailLogin);
        driver.findElement(By.xpath(LocatorCRM.password)).sendKeys(LocatorCRM.passwordLogin);
        driver.findElement(By.xpath(LocatorCRM.btnLogin)).submit();
        waitForPageLoaded();

        boolean checkURLNotAuth = driver.getCurrentUrl().contains("authentication");
        Assert.assertFalse(checkURLNotAuth);
        boolean checkURLContainsAdmin = driver.getCurrentUrl().contains("admin");
        Assert.assertTrue(checkURLContainsAdmin);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Header not exist, Login False");
//        Assert.assertTrue(checkURLNotAuth);
    }

    @Test
    public void testLoginWithEmailInvalid(){

        driver.get("https://crm.anhtester.com/admin/clients");
        waitForPageLoaded();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Not Login Page");
        driver.findElement(By.xpath(LocatorCRM.email)).sendKeys("admin@email.com");
        driver.findElement(By.xpath(LocatorCRM.password)).sendKeys(LocatorCRM.passwordLogin);
        driver.findElement(By.xpath(LocatorCRM.btnLogin)).submit();
        waitForPageLoaded();

        boolean checkURLNotAuth = driver.getCurrentUrl().contains("authentication");
        Assert.assertTrue(checkURLNotAuth);
//        boolean checkURLContainsAdmin = driver.getCurrentUrl().contains("admin");
//        Assert.assertFalse(checkURLContainsAdmin);
//        Assert.assertFalse(driver.findElements(By.xpath(LocatorCRM.menuDashboard)).size() > 0 ,"Header not exist, Login False");

        Assert.assertTrue(checkElementExist(LocatorCRM.messageAlert), "Fail, Alert message is Displayed");
        Assert.assertEquals(getTextElement(LocatorCRM.messageAlert), "Invalid email or password");
        Assert.assertFalse(checkElementExist(LocatorCRM.menuDashboard), "Header not exist, Login False");
    }
    @Test
    public void testLoginWithPasswordInvalid(){

        driver.get("https://crm.anhtester.com/admin/clients");
        waitForPageLoaded();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Not Login Page");
        driver.findElement(By.xpath(LocatorCRM.email)).sendKeys(LocatorCRM.emailLogin);
        driver.findElement(By.xpath(LocatorCRM.password)).sendKeys("12345");
        driver.findElement(By.xpath(LocatorCRM.btnLogin)).submit();
        waitForPageLoaded();

        //Hiện error message
        //Không đến được trang Dashboard
        //Vẫn còn ở lại trang login
        //URL chứa từ khoá authentication

        boolean checkURLNotAuth = driver.getCurrentUrl().contains("authentication");
        Assert.assertTrue(checkURLNotAuth);
//        boolean checkURLContainsAdmin = driver.getCurrentUrl().contains("admin");
//        Assert.assertFalse(checkURLContainsAdmin);
//        Assert.assertFalse(driver.findElements(By.xpath(LocatorCRM.menuDashboard)).size() > 0 ,"Header not exist, Login False");
        Assert.assertTrue(checkElementExist(LocatorCRM.headerLogin), "Fail, Not Login Page");
        Assert.assertTrue(checkElementExist(LocatorCRM.messageAlert), "Fail, Alert message is Displayed");
        Assert.assertEquals(getTextElement(LocatorCRM.messageAlert), "Invalid email or password");
        Assert.assertFalse(checkElementExist(LocatorCRM.menuDashboard), "Header not exist, Login False");
    }
//    KIỂM TRA MỘT CHỨC NĂNG BẰNG AUTOMATION TEST
//- Check header hiển thị đúng - mục đích biết được đã đến trang mình cần
//- Add new tất cả thông tin > Save
//- Search lại > Assert cái giá trị sau khi search
//- Click vào chi tiết
//- Assert hết tất cả các thông số mà mình đã Add New
//
//+ Ngoài ra cần đến các trang khác mà có liên quan đến thông số
//    của chức năng mình vừa thêm sửa xoá để Assert giá trị hiển thị
}
