package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static TestData.WebElements.expectedHeader;
import static TestData.WebElements.header;

public class TestCase1 {

    public void checkHeader(WebDriver driver) {

        try {
            System.out.println("Start Test Case 1");
            WebElement headerElement = driver.findElement(By.xpath(header));

            if (headerElement.getText().equals(expectedHeader)) {
                System.out.println("Section has the heading 25 of 2875 Transactions");
                System.out.println("Test Case 1 Passed");
            } else {
                System.out.println("Section does not have the expected heading");
                System.out.println("Test Case 1 Failed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Test Case 1 Failed");
        }
        System.out.println("End Test Case 1");
        System.out.println("");
    }
}
