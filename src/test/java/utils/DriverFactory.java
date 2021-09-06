package utils;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    private static final Properties properties = new Properties();

    public static RemoteWebDriver driverInit(String browserName){
        try {
            properties.load(new FileReader("src/test/resources/test.properties"));
            RemoteWebDriver driver;
            if (Boolean.parseBoolean(properties.getProperty("selenium.grid"))){
                DesiredCapabilities capabilities;
                switch (browserName){
                    case "Chrome":
                        capabilities = DesiredCapabilities.chrome();
                        break;
                    case "Firefox":
                        capabilities = DesiredCapabilities.firefox();
                        break;
                    default:
                        Assert.fail("No such driver was defined.");
                        return null ;
                }
                 driver = new RemoteWebDriver(new URL(properties.getProperty("hub.url")), capabilities);
            }
            else {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("disable-notifications");
                System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver");
                driver = new ChromeDriver(chromeOptions);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            return driver;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}