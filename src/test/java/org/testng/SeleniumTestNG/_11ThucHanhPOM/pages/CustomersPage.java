package org.testng.SeleniumTestNG._11ThucHanhPOM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SeleniumTestNG.keywords.keywords.WebUI;
import org.testng.SeleniumTestNG.locator.LocatorCRM;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CustomersPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private By menuAddNewCustomer = By.xpath("//a[normalize-space()='New Customer']");
    private By inputSearchCustomer = By.xpath("//div[@class='input-group']/input[@type='search']");
    private By headerCustomerPage = By.xpath("//span[normalize-space()='Customers Summary']");
    private String headerText = "Customers Summary";

    //Customer list
    private By firstItemCustomerOnTable = By.xpath("//td[@class='sorting_1']/a");

    //Add New Customer
    private By inputCompany = By.xpath("//input[@id='company']");
    private By inputVat = By.xpath("//input[@id='vat']");
    private By inputPhone = By.xpath("//input[@id='phonenumber']");
    private By inputWebsite = By.xpath("//input[@id='website']");
    private By dropDownGroup = By.xpath("//button[@data-id='groups_in[]']");
    private By inputGroup = By.xpath("//div[@app-field-wrapper='groups_in[]']//input[@type='search']");
    private By dropDownCurrency = By.xpath("//label[normalize-space()='Currency']/following-sibling::div//select[@id='default_currency']");
    private By inputCurrency = By.xpath("//div[@app-field-wrapper='default_currency']//input");
    private By dropDownLanguage = By.xpath("//button[@data-id='default_language']");
    private By optionLanguage = By.xpath("//span[normalize-space()='Vietnamese']");
    private By inputAddress = By.xpath("//textarea[@id='address']");
    private By inputCity = By.xpath("//input[@id='city']");
    private By inputState = By.xpath("//input[@id='state']");
    private By inputZipCode = By.xpath("//input[@id='zip']");
    private By dropDownCountry = By.xpath("//button[@data-id='country']");
    private By inputCountry = By.xpath("//button[@data-id='country']/following-sibling::div//input");
    private By btnSavencreate = By.xpath("//button[normalize-space()='Save and create contact']");
    private By btnSaveCustomer = By.xpath("//div[@id='profile-save-section']//button[normalize-space()='Save']");


    public CustomersPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        new WebUI(driver);
    }

    public void verifyHeaderCustomerPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(headerCustomerPage));
        Assert.assertTrue(driver.findElement(headerCustomerPage).isDisplayed(), "Header Customer Page NOT Display.");
        Assert.assertEquals(driver.findElement(headerCustomerPage).getText(), headerText, "Context of header customer page not match.");
    }

    public void clickButtonAddNew() {
        driver.findElement(menuAddNewCustomer).click();
    }


    public void inputFromData(String companyName) {
        WebUI.setText(inputCompany,companyName);
        WebUI.setText(inputVat,"123456");
        WebUI.setText(inputPhone,"99999999");
        WebUI.setText(inputWebsite,"https://anhtester.com");
        WebUI.clickElement(dropDownGroup);
        WebUI.setText(inputGroup,"VIP");
        driver.findElement(inputGroup).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        WebUI.setText(inputAddress,"Ho Chi Minh");
        WebUI.setText(inputCity,"Ho Chi Minh");
        WebUI.setText(inputState,"Ho Chi Minh");
        WebUI.setText(inputZipCode,"20000");
        WebUI.clickElement(dropDownCountry);
        WebUI.setText(inputCountry,"Vietnam");
        driver.findElement(inputCountry).sendKeys(Keys.ENTER);
        WebUI.sleep(1);
        WebUI.clickElement(btnSaveCustomer);
    }

    public void searchAndVerifyCustomer(String customer_Name) {
        driver.findElement(By.xpath(LocatorCRM.menuCustomer)).click();
        WebUI.setText(inputSearchCustomer,customer_Name);
        WebUI.sleep(1);
        Assert.assertTrue(WebUI.checkElementExist(firstItemCustomerOnTable), "Customer not exist");
        WebUI.sleep(1);
    }

    public void verifyCustomerDetail(String customer_Name){
        SoftAssert softAssert = new SoftAssert();
        WebUI.clickElement(firstItemCustomerOnTable);
        softAssert.assertEquals(driver.findElement(inputCompany).getAttribute("value"), customer_Name, "Company Name incorrect");
        softAssert.assertEquals(driver.findElement(inputVat).getAttribute("value"), "123456", "VAT incorrect");
        softAssert.assertEquals(driver.findElement(inputPhone).getAttribute("value"), "99999999", "Phone incorrect");
        softAssert.assertEquals(driver.findElement(inputWebsite).getAttribute("value"), "https://anhtester.com", "Website incorrect");
        softAssert.assertAll();
    }
}
