package org.example;

import TestCases.TestCase1;
import TestCases.TestCase2;
import Utils.Driver;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static TestData.WebElements.*;

public class Main {
    public static void main(String[] args)

    {
        WebDriver driver= Driver.InstantiateDriver();

        driver.get(URL);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        TestCase1 testCase1 = new TestCase1();
        testCase1.checkHeader(driver);

        TestCase2 testCase2 = new TestCase2();
        testCase2.parse(driver);

        driver.close();
    }
}