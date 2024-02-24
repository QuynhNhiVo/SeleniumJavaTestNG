package org.testng.SeleniumTestNG._1Annotations;

import org.openqa.selenium.By;
import org.testng.SeleniumTestNG.common.BaseTest;
import org.testng.annotations.Test;

public class CheckCustomernProject extends BaseTest {
    @Test(priority = 2)
    public void testCustomerAndProject() {
        //Login

        //Add Customer
        //new CustomerTest().testAddCustomer();//Test case
        new TestCustomer().testAddCustomer();//Hàm thường - Gọi từ Pages class

        //Add Project

        //Search Project
    }

    //Mở Browser mỗi lần
    @Test(priority = 2)
    public void testProjectAndTask() {
        //Login

        //Add Task

        //Add Project

        //Search Project
    }
}
