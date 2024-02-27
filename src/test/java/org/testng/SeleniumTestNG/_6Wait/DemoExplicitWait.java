package org.testng.SeleniumTestNG._6Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class DemoExplicitWait extends BaseTest {
    @Test
    public void testExplicitWait(){

        driver.get("https://hrm.anhtester.com");

        //Set timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        sleep(2);
        driver.quit();
    }
    @Test
    public void testExplicitWait2(){

        driver.get("https://hrm.anhtester.com");

        //Set timeout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.id("iusername")).sendKeys("admin_example");
        driver.findElement(By.id("ipassword")).sendKeys("123456");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        //Click menu dự án
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Projects')]")));

        driver.findElement(By.xpath("//span[contains(text(),'Projects')]")).click();

        driver.findElement(By.xpath("(//h5[contains(text(),'List All')]/following-sibling::div//a)[2]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Title']")));
        driver.findElement(By.xpath("//input[@placeholder='Title']")).sendKeys("Anh Tester");
//        wait.until(ExpectedConditions.presenceOfElementLocated())
        
        sleep(2);
        driver.quit();
    }
}
