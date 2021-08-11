package com.ajinz.test;
import com.ajinz.main.StringCalculator;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

@Test
public class StringCalculatorTest {
    private StringCalculator sc;

    @org.testng.annotations.BeforeMethod
    public void setUp() {
        System.out.println("Starting Tests...");
        sc = new StringCalculator();
    }

    public void emptyString(){
        assertEquals(sc.Add(""), 0);
    }
    public void emptyStringWithSpaces(){
        assertEquals(sc.Add(" "), 0);
    }
    public void oneNumber(){
        assertEquals(sc.Add("10"), 10);
    }
    public void multipleNumbers(){
        assertEquals(sc.Add("10, 50, 90, 100"), 250);
    }
    public void handleNewLines(){
        assertEquals(sc.Add("10, 20\n 30"), 60);
    }
    public void customDelimiter(){
        assertEquals(sc.Add("//;\\n1;2"), 3);
    }

    @org.testng.annotations.AfterMethod
    public void tearDown() {
        System.out.println("Completed");
    }

}
