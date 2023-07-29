package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.util.List;

import static TestData.WebElements.transactionBoxes;

public class TestCase2 {

    public void parse(WebDriver driver) {
        try {
            System.out.println("Start Test Case 2");
            System.out.println("The List of hashes are as follows:");
            List<WebElement> g = driver.findElements(By.xpath(transactionBoxes));
            for (int i = 1; i <= g.size(); i++) {
                List<WebElement> listOfInput = driver.findElements(By.xpath("//div[@class='transaction-box'][" + i + "]//div[@class='vin-header']"));
                List<WebElement> listOfOutput = driver.findElements(By.xpath("//div[@class='transaction-box'][" + i + "]//div[@class='vout-header']"));
                if (listOfInput.size() == 1 && listOfOutput.size() == 2) {
                    System.out.println(driver.findElement(By.xpath("//div[@class='transaction-box'][" + i + "]//div[@class='txn']/a")).getText());
                }

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Test Case 2 Failed");
        }
        System.out.println("End Test Case 2");
    }
}
