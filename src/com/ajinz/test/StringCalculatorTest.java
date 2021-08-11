package com.ajinz.test;
import com.ajinz.main.StringCalculator;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Test
public class StringCalculatorTest {

    @org.testng.annotations.BeforeMethod
    public void setUp() {
        System.out.println("Starting Tests...");

    }

    public void emptyString(){
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.Add(""), 0);
    }
    public void emptyStringWithSpaces(){
        StringCalculator sc = new StringCalculator();
        assertEquals(sc.Add(" "), 0);
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
        System.out.println("Completed");
    }

}
