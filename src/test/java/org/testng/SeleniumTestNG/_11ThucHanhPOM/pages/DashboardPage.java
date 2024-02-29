package org.testng.SeleniumTestNG._11ThucHanhPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SeleniumTestNG.keywords.keywords.WebUI;

import java.time.Duration;

public class DashboardPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuDashboard = By.xpath("//span[normalize-space()='Dashboard']");
    private By menuCustomer = By.xpath("//span[normalize-space()='Customers']");
    private By menuProject = By.xpath("//span[normalize-space()='Projects']");
    private By dropdownProfile = By.xpath("//li[contains(@class,'icon header-user-profile')]");
    private By optionLogout = By.xpath("(//a[@href='#'][normalize-space()='Logout'])[2]");
    private By menuReport = By.xpath("//span[normalize-space()='Reports']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new WebUI(driver);
    }

    public void clickMenuDashboard(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuDashboard));
        driver.findElement(menuDashboard).click();
    }

    public CustomersPage clickMenuCustomer(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuCustomer));
        driver.findElement(menuCustomer).click();

        return new CustomersPage(driver);
    }

    public void clickMenuProject(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuProject));
        driver.findElement(menuProject).click();
    }

    public LoginPage logOut(){
        driver.findElement(dropdownProfile).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(optionLogout));
        driver.findElement(optionLogout).click();

        return new LoginPage(driver);
    }

    public void verifyMenuReportDisplay(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.checkElementExist(menuCustomer), "Menu Report not Exist.");//check exist
        Assert.assertTrue(WebUI.getWebElement(menuCustomer).isDisplayed(), "Menu Report not Display.");//check display
    }

    public void verifyMenuReportNotDisplay(){
        WebUI.waitForPageLoaded();
        Assert.assertFalse(WebUI.checkElementExist(menuCustomer), "Menu Report is Display.");
    }
}
