package org.testng.SeleniumTestNG._2Assertions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

public class DemoHardAssert extends BaseTest {
    @Test
    public void testLoginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");

        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
        Assert.assertEquals(header, "Login", "Header incorrect ");
        Assert.assertNotEquals(header, "Login1");
//        Assert.assertEquals(header, "Login1", "Header incorrect ");

        boolean checkBtnLogin = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
        Assert.assertTrue(checkBtnLogin, "(True) Button Login Disable");
//        Assert.assertFalse(checkBtnLogin, "(False) Button Login Disable");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(1);

        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
//        Assert.assertTrue(menuName.contains("Customer1"), "Value menuName not contains expected value"); //Compare contains through Java
        Assert.assertTrue(menuName.contains("Customer"), "Value menuName not contains expected value");


    }
}
