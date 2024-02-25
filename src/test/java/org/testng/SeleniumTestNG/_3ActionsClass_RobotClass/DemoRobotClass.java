package org.testng.SeleniumTestNG._3ActionsClass_RobotClass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DemoRobotClass extends BaseTest {
    @Test
    public void inputText() throws AWTException {

        driver.get("https://anhtester.com/");

        sleep(1);
        WebElement inputCourseElement = driver.findElement(By.name("key"));

        inputCourseElement.click();

        Robot robot = new Robot();
        // Nhập từ khóa selenium
        robot.keyPress(KeyEvent.VK_S);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_L);
        robot.keyPress(KeyEvent.VK_E);
        robot.keyPress(KeyEvent.VK_N);
        robot.keyPress(KeyEvent.VK_I);
        robot.keyPress(KeyEvent.VK_U);
        robot.keyPress(KeyEvent.VK_M);
        sleep(1);
        robot.keyPress(KeyEvent.VK_ENTER);

        sleep(2);
    }
    @Test
    public void mousePress() throws InterruptedException, AWTException {

        driver.get("https://anhtester.com/");
        sleep(1);

        Robot robot = new Robot();
        //Di chuyển trỏ chuột đến vị trí x,y
        robot.mouseMove(1500, 200);
        //Dalay giống sleep
        robot.delay(1000);
        //Click chuột trái
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        //Thả chuột trái ra
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        sleep(2);

        //Duplicate tab
        robot.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);

        sleep(1);

        //Click chuột
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);

        sleep(1);
    }

    @Test
    public void createScreenCapture() throws AWTException, IOException {

        driver.get("https://anhtester.com/");
        sleep(1);

        Robot robot = new Robot();

        //Get size screen browser
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        System.out.println(screenSize);
//        //Khởi tạo kích thước khung hình với kích cỡ trên
//        Rectangle screenRectangle = new Rectangle(screenSize);
//        //Tạo hình chụp với độ lớn khung đã tạo trên
//        BufferedImage image = robot.createScreenCapture(screenRectangle);
//        //Lưu hình vào dạng file với dạng png
//        File file = new File("TestImageRobot.png");
//        ImageIO.write(image, "png", file);

        captureScreenImage("anhtesterPage1");
        sleep(1);
    }
    public void captureScreenImage(String imageName){
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

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

        sleep(1);

    }
}
