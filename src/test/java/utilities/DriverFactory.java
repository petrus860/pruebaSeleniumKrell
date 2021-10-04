package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    //    This method return a WebDriver Object
    public static WebDriver open(String browserType) {

        if (browserType.equalsIgnoreCase("chrome")) {
            // code for Chrome
            WebDriverManager.chromiumdriver().setup();
            return new ChromeDriver();
        } else if (browserType.equals("firefox")) {
            // code for FF
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        } else if (browserType.equals("IE")) {
            // code for FF
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }

        return null;
    }
}
