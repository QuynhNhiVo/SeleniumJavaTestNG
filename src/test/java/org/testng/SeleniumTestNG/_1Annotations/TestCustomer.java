package org.testng.SeleniumTestNG._1Annotations;

import org.openqa.selenium.By;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

public class TestCustomer extends BaseTest {
    @Test(priority = 1)
    public void testAddCustomer(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
    }

    @Test(priority = 2)
    public void testFilterCustomer(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
    }

    @Test(priority = 3)
    public void testAddCustomerDuplicated(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
    }

    @Test(priority = 4)
    public void testEditCustomer(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
    }

    @Test(priority = 5)
    public void testDeleteCustomer(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
    }

    @Test
    public void testDeleteCustomerFlow(){
        driver.get("https://crm.anhtester.com/admin/authentication");
        driver.findElement(By.xpath("//span[normalize-space()='Customers']")).click();
    }
}
