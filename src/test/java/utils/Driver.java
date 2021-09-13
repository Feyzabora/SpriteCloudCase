package utils;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Driver {

    private static final Properties properties = new Properties();
    public static RemoteWebDriver driver;
    public static WebDriverWait wait;

    public void init() {//Init method  uses the Driverfactory to start a driver which is then saved in the driver class.
        try {
            properties.load(new FileReader("src/test/resources/test.properties"));
            driver = DriverFactory.driverInit(properties.getProperty("browser"));
            assert driver != null;
            wait = new WebDriverWait(driver, 10);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void teardown(){ driver.quit(); }
}//The driver factory initialize the driver and driver calls the driver factory