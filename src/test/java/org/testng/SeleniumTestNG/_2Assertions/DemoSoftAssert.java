package org.testng.SeleniumTestNG._2Assertions;

import org.openqa.selenium.By;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoSoftAssert extends BaseTest {
//    SoftAssert softAssert = new SoftAssert();
//    @AfterClass
//    public void assertAllCase(){
//        softAssert.assertAll();
//    }

    @Test
    public void testLoginCRM(){
        driver.get("https://crm.anhtester.com/admin/authentication");

        SoftAssert softAssert = new SoftAssert();

        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
//        Assert.assertEquals(header, "Login", "Header incorrect ");
//        softAssert.assertNotEquals(header, "Login1");
        softAssert.assertEquals(header, "Login1", "Header incorrect ");

        boolean checkBtnLogin = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
//        softAssert.assertTrue(checkBtnLogin, "(True) Button Login Disable");
        softAssert.assertFalse(checkBtnLogin, "(False) Button Login Disable");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(1);

        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
        softAssert.assertTrue(menuName.contains("Customer1"), "Value menuName not contains expected value"); //Compare contains through Java
//        softAssert.assertTrue(menuName.contains("Customer"), "Value menuName not contains expected value");

        softAssert.assertAll();
    }
    @Test
    public void testLoginCRM2(){
        driver.get("https://crm.anhtester.com/admin/authentication");

        SoftAssert softAssert = new SoftAssert();

        String header = driver.findElement(By.xpath("//h1[normalize-space()='Login']")).getText();
        System.out.println(header);
//        Assert.assertEquals(header, "Login", "Header incorrect ");
        softAssert.assertNotEquals(header, "Login1");
//        softAssert.assertEquals(header, "Login1", "Header incorrect ");

        boolean checkBtnLogin = driver.findElement(By.xpath("//button[@type='submit']")).isEnabled();
//        softAssert.assertTrue(checkBtnLogin, "(True) Button Login Disable");
        softAssert.assertFalse(checkBtnLogin, "(False) Button Login Disable");

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin@example.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        sleep(1);

        String menuName = driver.findElement(By.xpath("//span[normalize-space()='Customers']")).getText();
//        softAssert.assertTrue(menuName.contains("Customer1"), "Value menuName not contains expected value"); //Compare contains through Java
        softAssert.assertTrue(menuName.contains("Customer"), "Value menuName not contains expected value");

        softAssert.assertAll();
    }
}
