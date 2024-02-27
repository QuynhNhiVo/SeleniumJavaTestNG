package org.testng.SeleniumTestNG.thuchanh;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.SeleniumTestNG.keywords.ActionKeywords;
import org.testng.SeleniumTestNG.locator.LocatorCRM;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddNewCustomer extends BaseTest {
    public void loginCRM(){

        driver.get("https://crm.anhtester.com/admin/clients");

        String companyName = "12 Company New";
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Not Login Page");
        driver.findElement(By.xpath(LocatorCRM.email)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.password)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.btnLogin)).submit();
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Header not exist, Login False");
    }

    String companyName = "12 Company New";
    @Test
    public void testAddNewCustomer(){

        driver.get("https://crm.anhtester.com/admin/clients");

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerLogin)).isDisplayed(), "Not Login Page");
        driver.findElement(By.xpath(LocatorCRM.email)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.password)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.btnLogin)).submit();
        sleep(1);
//        new ActionKeywords(driver);(c1 ham xay dung)
//        ActionKeywords act= new ActionKeywords(driver);(C2 constructor)
//        act.setTect(LocatorCRM.email, "admin@example.com");
//        act.setTect(LocatorCRM.password, "123456");
//        driver.findElement(By.xpath(LocatorCRM.btnLogin)).submit();
//        sleep(1);
//
//        setTest(LocatorCRM.email, "admin@example.com");
//        setTest(LocatorCRM.password, "123456");
//        driver.findElement(By.xpath(LocatorCRM.btnLogin)).submit();
//        sleep(1);

        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.menuDashboard)).isDisplayed(), "Header not exist, Login False");
        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerCustomer)).isDisplayed(), "Can't get to Customer Page");
        Assert.assertEquals(driver.findElement(By.xpath(LocatorCRM.headerCustomer)).getText(), "Customers Summary","Header of Customer Page is not correct");
        sleep(1);

        //Add New Customer
        driver.findElement(By.xpath(LocatorCRM.newCustomer)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputCompany)).sendKeys(companyName);
        driver.findElement(By.xpath(LocatorCRM.inputVat)).sendKeys("123456");
        driver.findElement(By.xpath(LocatorCRM.inputPhone)).sendKeys("99999999");
        driver.findElement(By.xpath(LocatorCRM.inputWebsite)).sendKeys("https://anhtester.com");
        Select selectGroup = new Select(driver.findElement(By.xpath(LocatorCRM.dropDownGroup)));
        selectGroup.selectByValue("2");
        sleep(1);

        Select selectCurrency = new Select(driver.findElement(By.xpath(LocatorCRM.dropDownCurrency)));
        selectCurrency.selectByValue("1");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputAddress)).sendKeys("Ho Chi Minh");
        driver.findElement(By.xpath(LocatorCRM.inputCity)).sendKeys("Ho Chi Minh");
        driver.findElement(By.xpath(LocatorCRM.inputState)).sendKeys("Ho Chi Minh");
        driver.findElement(By.xpath(LocatorCRM.inputZipCode)).sendKeys("20000");

        driver.findElement(By.xpath(LocatorCRM.dropDownCountry)).click();
        driver.findElement(By.xpath(LocatorCRM.inputCountry)).sendKeys("Vietnam");
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.inputCountry)).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath(LocatorCRM.btnSaveCustomer)).click();
        sleep(2);

        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        sleep(2);

        //Search Value New Customer
        driver.findElement(By.xpath(LocatorCRM.searchCustomer)).sendKeys(companyName);
        sleep(2);
        String firstSearch =  driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).getText();
        Assert.assertEquals(companyName,firstSearch);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Customer not exist");
        sleep(2);

        //Check Value After Add New Customer
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        sleep(2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputCompany)).getAttribute("value"), companyName, "Company Name incorrect");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputVat)).getAttribute("value"), "123456", "VAT incorrect");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputPhone)).getAttribute("value"), "99999999", "Phone incorrect");
        softAssert.assertEquals(driver.findElement(By.xpath(LocatorCRM.inputWebsite)).getAttribute("value"), "https://anhtester.com", "Website incorrect");
        softAssert.assertAll();
    }
    @Test
    public void testAddNewContact(){
        loginCRM();
        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        sleep(1);
        driver.findElement(By.xpath(LocatorCRM.searchCustomer)).sendKeys(companyName);
        sleep(2);
        String firstSearch =  driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).getText();
        Assert.assertEquals(companyName,firstSearch);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).isDisplayed(), "Customer not exist");
        sleep(2);
        driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).click();
        sleep(2);
        driver.findElement(By.xpath(LocatorCRM.menuContact)).click();
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerContact)).isDisplayed(), "Can't get to Contact Page");
        driver.findElement(By.xpath(LocatorCRM.addNewContact)).click();
        sleep(2);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.headerAddNewContactDialog)).isEnabled(), "Not find Dialog Add New Contact");
        driver.findElement(By.xpath(LocatorCRM.profileContact)).sendKeys(System.getProperty("user.dir") + "\\src\\test\\java\\resources\\datatest\\img.png");

        driver.findElement(By.xpath(LocatorCRM.firstNameContact)).sendKeys("1 Contact");
        driver.findElement(By.xpath(LocatorCRM.lastNameContact)).sendKeys("Name");
        driver.findElement(By.xpath(LocatorCRM.positionContact)).sendKeys("HCM");
        driver.findElement(By.xpath(LocatorCRM.emailContact)).sendKeys("admin@example.com");
        driver.findElement(By.xpath(LocatorCRM.phoneContact)).sendKeys("1111111");

        Select selectDirection = new Select(driver.findElement(By.xpath(LocatorCRM.directionContact)));
        selectDirection.selectByValue("rtl");

        driver.findElement(By.xpath(LocatorCRM.passwordContact)).sendKeys("123456");
        sleep(1);
        Assert.assertTrue(driver.findElement(By.xpath(LocatorCRM.btnShowPasswordContact)).isEnabled(), "Button show password disable");
        driver.findElement(By.xpath(LocatorCRM.btnShowPasswordContact)).click();
        driver.findElement(By.xpath(LocatorCRM.checkboxNotSendContact)).click();
        driver.findElement(By.xpath(LocatorCRM.btnSaveContact)).click();
        sleep(1);

        Assert.assertEquals("1 Contact", driver.findElement(By.xpath(LocatorCRM.firstItemCustomerOnTable)).getText());

        sleep(3);
    }
}
