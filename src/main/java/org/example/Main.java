package org.example;

import TestCases.APITestCase1;
import TestCases.APITestCase2;
import TestCases.TestCase1;
import TestCases.TestCase2;
import TestData.APITestData;
import Utils.Driver;
import com.beust.ah.A;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static TestData.WebElements.*;

public class Main {
    public static void main(String[] args)

    {
        APITestCase1 apiTestCase1 = new APITestCase1();
        apiTestCase1.SendRequest();

        APITestCase2 apiTestCase2 = new APITestCase2();
        apiTestCase2.SendRequest();

    }
}