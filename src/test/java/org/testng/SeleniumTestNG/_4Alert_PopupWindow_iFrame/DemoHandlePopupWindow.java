package org.testng.SeleniumTestNG._4Alert_PopupWindow_iFrame;

import org.openqa.selenium.By;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

import javax.swing.plaf.IconUIResource;
import java.util.Set;

public class DemoHandlePopupWindow extends BaseTest {
    @Test
    public void demoPopupTypeTab() {
        driver.get("https://demoqa.com/browser-windows");
        sleep(2);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        sleep(2);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
                //Chuyển hướng driver đến Tab mới (Tab con)
                driver.switchTo().window(window);
                sleep(1);
                System.out.println("Đã chuyển đến Tab Window mới");

                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());

                sleep(1);
                //Sau khi chuyển hướng sang Tab mới thì getText cái header
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());

                // Tắt cái Tab Window mới.
                sleep(1);
                driver.close();
            }
        }
        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(1);
    }
    @Test
    public void demoSetPopupTypeTab() {
        driver.get("https://demoqa.com/browser-windows");
        sleep(2);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        sleep(1);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        String window1 = windows.toArray()[0].toString(); //Là cửa số thứ 1 = Main window
        String window2 = windows.toArray()[1].toString(); //Là cửa sổ thứ 2

        driver.switchTo().window(window2); //Chuyển hướng đến cửa sổ mới thứ 2
        System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
        //driver.close(); //Đóng cửa sổ hiện tại

        // Chuyển hướng về lại tab chính ban đầu (Main Window)
        driver.switchTo().window(MainWindow);
        driver.switchTo().window(window2);
        driver.close(); //Đóng cửa sổ Main
        driver.switchTo().window(MainWindow);
        System.out.println("Đã chuyển về lớp Window chính: " + driver.getCurrentUrl());

        sleep(1);
    }
    @Test
    public void demoSetPopupTypeTab2() {
        driver.get("https://demoqa.com/browser-windows");
        sleep(2);
        driver.findElement(By.xpath("//button[@id='tabButton']")).click();
        sleep(1);
        // Lưu lại lớp window đầu tiên - mã ID hơi dài, in ra sẽ thấy :)
        String MainWindow = driver.getWindowHandle();
        System.out.println(MainWindow);

        // Lấy tất cả các mã định danh Tab Window.
        Set<String> windows = driver.getWindowHandles();

        //Set là một Collection để lưu các phần tử giá trị KHÔNG trùng lặp.
        //Cách duyệt từng phần tử không trùng lặp trong Collection (Set) - Java Basic
        for (String window : windows) {
            System.out.println(window);
            if (!MainWindow.equals(window)) {
//                //So sánh nếu thằng nào khác thằng Chính (đầu tiên) thì chuyển hướng qua nó mới thao tác được
//                //Chuyển hướng driver đến Tab mới (Tab con)
                driver.switchTo().window(window);
                sleep(1);
                System.out.println("Đã chuyển đến Tab Window mới");

                String title = driver.switchTo().window(window).getTitle();

                if (title == "Hello") {
                    //Làm gì đó
                } else {
                    continue; //Tiep tục vòng lặp
//                    break; //Thoát vòng lặp
                }
//
//                //Một số hàm hỗ trợ
                System.out.println(driver.switchTo().window(window).getTitle());
                System.out.println(driver.switchTo().window(window).getCurrentUrl());
//
                sleep(1);
//                //Sau khi chuyển hướng sang Tab mới thì getText cái header
                System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
//
//                // Tắt cái Tab Window mới.
                sleep(1);
                driver.close(); //Đóng cửa sổ hiện tại
            }
//        }

            String window1 = windows.toArray()[0].toString(); //Là cửa số thứ 1 = Main window
            String window2 = windows.toArray()[1].toString(); //Là cửa sổ thứ 2

            driver.switchTo().window(window2); //Chuyển hướng đến cửa sổ mới thứ 2
            System.out.println(driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText());
            driver.close(); //Đóng cửa sổ hiện tại
        }
    }
    @Test
    public void testPopupWindow(){
        driver.get("http://demo.seleniumeasy.com/window-popup-modal-demo.html");
        sleep(1);

        String mainWindow = driver.getWindowHandle();
        System.out.println(mainWindow);

        driver.findElement(By.xpath("//a[normalize-space()='Follow Twitter & Facebook']")).click();

        driver.switchTo().window(mainWindow);
        driver.findElement(By.xpath("//a[@id='followall']")).click();
        Set<String> windows = driver.getWindowHandles();

        int i = 0;
        for (String window :windows){
            System.out.println(window);
            if(!mainWindow.equals(window)){
                driver.switchTo().window(window);
                sleep(1);
                System.out.println("Title: " + (i++) + driver.getTitle());
                String title = driver.switchTo().window(window).getTitle();

                driver.close();
            }
        }
        String window1 = windows.toArray()[0].toString();
        String window2 = windows.toArray()[1].toString();
        String window3 = windows.toArray()[2].toString();

        driver.switchTo().window(mainWindow);
        driver.quit();
    }
}
