package org.testng.SeleniumTestNG.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ActionKeywords {
   private static WebDriver driver;


    public ActionKeywords(WebDriver driver) {
        this.driver = driver;
    }
    public void setTest(String locator, String text){
        driver.findElement(By.xpath(locator)).sendKeys(text);
    }
}
