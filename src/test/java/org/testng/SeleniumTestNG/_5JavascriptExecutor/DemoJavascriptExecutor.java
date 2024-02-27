package org.testng.SeleniumTestNG._5JavascriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

public class DemoJavascriptExecutor extends BaseTest {
    @Test
    public void test01(){
        driver.get("https://cms.anhtester.com/");

        WebElement buttonCloseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement btnViewAllCategory = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement btnApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));

        buttonCloseWelcomeDialog.click();
//        menuBlogs.click();
//        btnViewAllCategory.click();
//        btnApplyNow.click();

        //Use Javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].click();", menuBlogs);


        sleep(2);
        driver.quit();
    }
    @Test
    public void test02(){
        driver.get("https://cms.anhtester.com/");

        WebElement buttonCloseWelcomeDialog = driver.findElement(By.xpath("//button[@data-key='website-popup']"));
        WebElement menuBlogs = driver.findElement(By.xpath("//a[normalize-space()='Blogs']"));
        WebElement btnViewAllCategory = driver.findElement(By.xpath("//a[normalize-space()='View All Categories']"));
        WebElement btnApplyNow = driver.findElement(By.xpath("//a[normalize-space()='Apply Now']"));

        buttonCloseWelcomeDialog.click();

        //Use Javascript
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Chiều cao và Chiều rộng của một trang web
        System.out.println(js.executeScript("return window.innerHeight;").toString());
        System.out.println(js.executeScript("return window.innerWidth;").toString());
        sleep(1);
        //URL
        System.out.println(js.executeScript("return document.URL;").toString());
        sleep(1);
        //Domain
        System.out.println(js.executeScript("return document.domain;").toString());
        sleep(1);
        //Title
        System.out.println(js.executeScript("return document.title;").toString());
        sleep(1);
        WebElement inputSearch = driver.findElement(By.xpath("//input[@id='search']"));
        js.executeScript("arguments[0].setAttribute('value', 'Qua tet');", inputSearch);
        sleep(2);

        //Cuộn chuột đến vị trí Top của phần tử
//        js.executeScript("arguments[0].scrollIntoView(true)", btnViewAllCategory);
//        btnViewAllCategory.click();
        //Cuộn chuột đến vị trí Bottom của phần tử
//        js.executeScript("arguments[0].scrollIntoView(false)", btnViewAllCategory);
//        btnViewAllCategory.click();
        //Cuộn chuột đến vị trí Bottom của phần tử
//        js.executeScript("window.scrollTo(0,500)");

        //Tô màu viền của Element
        js.executeScript("arguments[0].scrollIntoView(true)", btnViewAllCategory);
        js.executeScript("arguments[0].style.border='3px solid blue'", btnViewAllCategory);
        sleep(2);


        sleep(2);
        driver.quit();
    }
}
