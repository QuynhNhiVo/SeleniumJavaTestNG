package org.testng.SeleniumTestNG._10LinkPage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By inputSearchCustomer = By.xpath("//div[@class='input-group']/input[@type='search']");

    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickButtonAddNew(){
        driver.findElement(menuAddNewCustomer).click();
    }

    public void searchCustomer(String customerName){
        driver.findElement(inputSearchCustomer).sendKeys(customerName);
    }
}
