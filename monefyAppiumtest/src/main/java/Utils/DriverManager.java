package Utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static AndroidDriver androidDriver;
    private static final String appPath = System.getProperty("user.dir") + "/src/main/resources/app/com.monefy.app.lite_2021-09-27.apk";

    private static Capabilities getCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.22.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Pixel XL API 30");
        capabilities.setCapability("platformVersion", "11");
        capabilities.setCapability("appWaitActivity", "*");
        capabilities.setCapability("app", appPath);
//        capabilities.setCapability("noReset", true);
        capabilities.setCapability("newCommandTimeout", 100000);

        return capabilities;
    }

    public static AndroidDriver openDriver() {
        try {
            androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), getCapabilities());
            androidDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return androidDriver;
        } catch (Exception exception) {
            throw new WebDriverException(exception.getMessage());
        }
    }

    public static void closeDriver() {
        try {
            androidDriver.closeApp();
        } catch (Exception exception) {
            throw new WebDriverException(exception.getMessage());
        }
    }

    public static void launchApp() {
        androidDriver.launchApp();
    }
}
