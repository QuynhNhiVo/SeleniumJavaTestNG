package org.testng.SeleniumTestNG._4Alert_PopupWindow_iFrame;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class DemoHandleIframe extends BaseTest {
    @Test
    public void testIFrame01(){

        driver.navigate().to("https://anhtester.com/contact");
        sleep(9);
        System.out.println("iframe total: " + driver.findElements(By.tagName("iframe")).size());
        sleep(2);
        //----Switch to content of Messenger--------
        driver.switchTo().frame(0); //Thẻ iframe thứ nhất
        System.out.println(driver.findElement(By.tagName("strong")).getText());

        //----Switch to icon of Messenger---------

        //1. Switch to Parent WindowHandle
        driver.switchTo().parentFrame(); //Chuyển về nội dung chính không thuộc iframe nào

        //2. Switch to iframe icon of Messenger
        driver.switchTo().frame(1); //Thẻ iframe thứ hai
        driver.findElement(By.tagName("svg")).click(); //Nhấn icon để ẩn messenger chat đi

        sleep(2);
    }
    @Test
    public void testIFrame02(){
        driver.get("https://anhtester.com/contact");
        sleep(10);
        System.out.println("Total iframe: " + driver.findElements(By.tagName("iframe")).size());
        sleep(5);

        List iframes = driver.findElements(By.tagName("iframe"));
        sleep(2);

        for(int i =0; i < iframes.size(); i++){
            sleep(2);
            driver.switchTo().frame(i);
            String iframe = driver.getTitle();
            System.out.println("iframe index: " + i + ". Title: " + iframe);
            driver.switchTo().parentFrame();
        }

//        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
//
//        for(WebElement iframe :iframes){
//            driver.switchTo().frame(iframe);
//            String title = driver.getTitle();
//            System.out.println(title);
//            driver.switchTo().parentFrame();
//            sleep(3);
//        }
        driver.switchTo().parentFrame();
        driver.quit();
    }
    @Test
    public void testIFrameOnVNExpress(){
        driver.get("https://vnexpress.net/");
        sleep(6);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/27973503/Vnexpress/Desktop/Masthead/Home_0']")));
        int div = driver.findElements(By.xpath("(//div[contains(@id,'genecy_ifr_')])")).size();
        System.out.println(div);
        driver.findElement(By.xpath("(//div[contains(@id,'genecy_ifr_')])")).click();
        sleep(2);
    }
    @Test
    public void testIFrameOnVNExpress2(){
        driver.get("https://vnexpress.net/");
        sleep(7);
//        System.out.println("Total iframe: " + driver.findElements(By.tagName("iframe")).size());
//        sleep(5);
//
//        List iframes = driver.findElements(By.tagName("iframe"));
//        sleep(3);
//
//        for(int i =0; i < iframes.size(); i++){
//            sleep(3);
//            driver.switchTo().frame(i);
//            String iframe = driver.getTitle();
//            System.out.println("iframe index: " + i + ". Title: " + iframe);
//            driver.switchTo().parentFrame();
//        }
//        sleep(3);

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='google_ads_iframe_/27973503/Vnexpress/Desktop/Masthead/Home_0']")));
        int div = driver.findElements(By.xpath("(//div[contains(@id,'genecy_ifr_')])")).size();
        System.out.println(div);
        driver.findElement(By.xpath("(//div[contains(@id,'genecy_ifr_')])")).click();
        sleep(2);
    }
}
