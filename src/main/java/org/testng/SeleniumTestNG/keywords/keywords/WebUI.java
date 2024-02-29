package org.testng.SeleniumTestNG.keywords.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class WebUI {
    private static int TIMEOUT = 10;
    private static double STEP_TIME = 0.5;
    private static int PAGE_LOAD_TIMEOUT = 20;

   private static WebDriver driver;

    public WebUI(WebDriver driver) {
        this.driver = driver;
    }

    public static Boolean checkElementExist(By by) {
        List<WebElement> listElement = driver.findElements(by);

        if (listElement.size() > 0) {
            System.out.println("Element " + by + " existing.");
            return true;
        } else {
            System.out.println("Element " + by + " NOT exist.");
            return false;
        }
    }

    public static WebElement getWebElement(By by) {
        return driver.findElement(by);
    }

    public static List<WebElement> getWebElements(By by) {
        return driver.findElements(by);
    }

    public static void logConsole(Object message) {
        System.out.println(message);
    }

    public static void openURL(String url) {
        driver.get(url);
        logConsole("Open: " + url);
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static void clickElement(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        getWebElement(by).click();
        logConsole("Click on Element: " + by);
    }

    public static void clickElement(By by, int timeOut){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        getWebElement(by).click();
        logConsole("Click on Element: " + by + " Timeout: " + timeOut);

    }

    public static void setText(By by, String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        getWebElement(by).sendKeys(text);
        logConsole("Set text on element: " + by + " Text: " + text);
    }

    public static void setText(By by, String text, int timeOut){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        getWebElement(by).sendKeys(text);
        logConsole("Set text on element: " + by + " Timeout: " + timeOut + " Text: " + text);
    }

    public static String getElementText(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        String text = driver.findElement(by).getText();
        logConsole("Get text of element: " + by + " is: " + text);
        return text; //Trả về một giá trị kiểu String
    }

    public static void sleep(double second){
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Chờ đợi trang load xong mới thao tác
    public static void waitForPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(PAGE_LOAD_TIMEOUT), Duration.ofMillis(500));
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Wait for Javascript to load
        ExpectedCondition < Boolean > jsLoad = new ExpectedCondition< Boolean >() {
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


    public static void captureScreenImage(String imageName) {
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        //Get size screen browser
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        System.out.println(screenSize);
        //Khởi tạo kích thước khung hình với kích cỡ trên
        Rectangle screenRectangle = new Rectangle(screenSize);
        //Tạo hình chụp với độ lớn khung đã tạo trên
        BufferedImage image = robot.createScreenCapture(screenRectangle);
        //Lưu hình vào dạng file với dạng png
        File file = new File(imageName + ".png");
        try {
            ImageIO.write(image, "png", file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
