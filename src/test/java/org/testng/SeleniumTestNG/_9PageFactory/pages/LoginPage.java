package org.testng.SeleniumTestNG._9PageFactory.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SeleniumTestNG.keywords.constants.ConfigData;

import java.time.Duration;
import java.util.List;

public class LoginPage {

    //Khai báo driver cục bộ trong chính class này
    private WebDriver driver;
    private WebDriverWait wait;

    //Khai báo các element dạng đối tượng By (phương thức tìm kiếm)
//    private By inputEmail = By.xpath("//input[@id='email']");
//    private By inputPassword = By.xpath("//input[@id='password']");
//    private By headerPage = By.xpath("//h1[normalize-space()='Login']");
//    private By buttonLogin = By.xpath("//button[@type='submit']");
//    private By errorMessage = By.xpath("//div[@id='alerts']");

    @FindBy(xpath = "//h1[normalize-space()='Login']")
    WebElement headerPage;

    @FindBy(xpath = "//input[@id='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[normalize-space()='Login']")
    WebElement buttonLogin;

    @FindBy(xpath = "//div[@id='alerts']")
    WebElement errorMessage;

    @FindBys(@FindBy(xpath = "//ul[@id='side-menu']"))
    List<WebElement> listMenu;

    @FindAll({
            @FindBy(xpath = "//span[normalize-space()='Customers']"),
            @FindBy(xpath = "//ul[@id='side-menu']/li[3]")
    })
    WebElement menuCustomer;

    //Can't click element
//    @FindAll({
//            @FindBy(xpath = "//span[normalize-space()='Customers23']"),
//            @FindBy(xpath = "//ul[@id='side-menu']/li[3]")
//    })
//    WebElement menuCustomer;

    //Khai báo hàm xây dựng để truyền driver từ bên ngoài vào class này sử dụng
    public LoginPage(WebDriver driver) {
        this.driver = driver;
//        driver=_driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //Khởi tạo giá trị cho các đối tượng WebElement trên (thực thi tìm kiếm)
        PageFactory.initElements(driver, this);
    }

    private void setEmail(String email){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
//        driver.findElement(inputEmail).sendKeys(email);
        wait.until(ExpectedConditions.visibilityOf(inputEmail));
        inputEmail.sendKeys(email);
    }

    private void setPassword(String password){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(inputPassword));
//        driver.findElement(inputPassword).sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        inputPassword.sendKeys(password);
    }

    private void clickLoginButton() {
        //wait.until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
        //driver.findElement(buttonLogin).click();
        wait.until(ExpectedConditions.visibilityOf(buttonLogin));
        buttonLogin.click();
    }

    private void getMenuList(){
        for (WebElement menu: listMenu){
            System.out.println(menu.getText());
        }
    }
    public void verifyLoginSuccess(){
        Assert.assertFalse(driver.getCurrentUrl().contains("authentication"), "Fail. Còn ở Login Page");
    }

    public void verifyLoginFail(){
//        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "Fail. Không òn ở Login Page");
//        Assert.assertTrue(driver.findElement(errorMessage).isDisplayed(), "Error message not display");
//        Assert.assertEquals(driver.findElement(errorMessage).getText(), "Invalid email or password", "Error message incorrect");
        //Check menu dashboard not display
        Assert.assertTrue(driver.getCurrentUrl().contains("authentication"), "Fail. Không còn ở Login Page");
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not display");
        Assert.assertEquals(errorMessage.getText(), "Invalid email or password", "Error message incorrect");
    }

    //Các hàm xử lý cho trang này
    public void loginCRM(String email, String password) {
        driver.get(ConfigData.URL); //gọi từ class config data dạng biến static
        setEmail(email);
        setPassword(password);
        clickLoginButton();
        waitForPageLoaded();
        getMenuList();
        menuCustomer.click();
    }

    public void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return js.executeScript("return document.readyState").toString().equals("complete");
            }

        };

        //Check JS is Ready
        boolean jsReady = js.executeScript("return document.readyState").toString().equals("complete");

        //Wait Javascript until it is Ready!
        if (!jsReady) {
            System.out.println("Javascript is NOT Ready.");
            //Wait for Javascript to load
            try {
                wait.until(jsLoad);
            } catch (Throwable error) {
                error.printStackTrace();
                Assert.fail("FAILED. Timeout waiting for page load.");
            }
        }
    }
    public void sleep(double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

