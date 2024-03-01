package org.testng.SeleniumTestNG._12Parameters_MultiBrowser;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoParameters2 {

    @Test
    @Parameters({"number1", "number2"})
    public void testDiv01(int a, int b){
        System.out.println("Div01: " + (a + b));
    }

    @Test
    @Parameters({"number1", "number2"})
    public void testMul1(int a, int b){
        System.out.println("Mul01: " + (a - b));
    }
}
