package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Driver {


    public static WebDriver InstantiateDriver() {

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-allow-origins=*");
        System.setProperty("webdriver.edge.driver", "src/main/resources/Drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver(options);
        return driver;
    }

}
