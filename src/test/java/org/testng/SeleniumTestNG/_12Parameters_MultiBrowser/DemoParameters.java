package org.testng.SeleniumTestNG._12Parameters_MultiBrowser;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters {

    @Test
//    @Parameters({"number1", "number2"})
    public void testSum01(@Optional("2") int a, @Optional("2")  int b){
        System.out.println("Sum01: " + (a + b));
    }

    @Test
    @Parameters({"number1", "number2"})
    public void testSub1(int a, int b){
        System.out.println("Sub01: " + (a - b));
    }
}
