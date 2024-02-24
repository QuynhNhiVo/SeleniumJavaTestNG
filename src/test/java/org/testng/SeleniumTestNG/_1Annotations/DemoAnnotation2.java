package org.testng.SeleniumTestNG._1Annotations;

import org.testng.annotations.*;

public class DemoAnnotation2 {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Before Test");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("After Test");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }

    @BeforeGroups(groups = { "testOne" })
    public void beforeGroupOne() {
        System.out.println("Before Group testOne2");
    }

    @AfterGroups(groups = { "testOne" })
    public void afterGroupOne() {
        System.out.println("After Group testOne2");
    }

    @BeforeGroups(groups = { "testTwo" })
    public void beforeGroupTwo() {
        System.out.println("Before Group testTwo2");
    }

    @AfterGroups(groups = { "testTwo" })
    public void afterGroupTwo() {
        System.out.println("After Group testTwo2");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @Test(groups = { "testOne" }, priority = 1)
    public void test1Method() {
        System.out.println("Test method demo1");
    }

    @Test(groups = { "testTwo" }, priority = 2)
    public void test2Method() {System.out.println("Test method demo2");
    }
    @Test(groups = { "testOne" }, priority = 3)
    public void test3Method() {
        System.out.println("Test method demo3");
    }

    @Test(groups = { "testTwo" }, priority = 4)
    public void test4Method() {
        System.out.println("Test method demo4");
    }
}
