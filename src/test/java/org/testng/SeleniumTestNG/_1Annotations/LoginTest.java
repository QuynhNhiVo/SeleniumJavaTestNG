package org.testng.SeleniumTestNG._1Annotations;

import org.openqa.selenium.By;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    @Test(priority = 1)
    public void testLoginSuccess(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    @Test(priority = 2)
    public void testAddCustomer(){
        testLoginSuccess();
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
    }
}
