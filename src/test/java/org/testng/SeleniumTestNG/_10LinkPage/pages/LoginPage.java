package org.testng.SeleniumTestNG._10LinkPage.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SeleniumTestNG.keywords.constants.ConfigData;

import java.time.Duration;

public class LoginPage {

    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
    private By inputEmail = By.xpath("//input[@id='email']");
    private By inputPassword = By.xpath("//input[@id='password']");
    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
    private By buttonLogin = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//div[@id='alerts']");

    //Khai báo hàm xây dựng để truyền driver từ bên ngoài vào class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
//        driver=_driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private void setEmail(String email){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys(email);
    }

    private void setPassword(String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
        driver.findElement(inputPassword).sendKeys(password);
    }

    private void clickButtonLogin(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        driver.findElement(buttonLogin).click();
    }

    public void verifyLoginSuccess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "Fail. Còn ở Login Page");
    }

    public void verifyLoginFail(){
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "Fail. Không òn ở Login Page");
        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message not display");
        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Error message incorrect");
        //Check menu dashboard not display
    }

    //Các hàm xử lý cho trang này
    public DashboardPage loginCRM(String email, String password) {
        driver.get(ConfigData.URL); //gọi từ class config data dạng biến static
        setEmail(email);
        setPassword(password);
        clickButtonLogin();

        return new DashboardPage(driver);
    }
}

