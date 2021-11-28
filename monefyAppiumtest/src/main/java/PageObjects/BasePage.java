package PageObjects;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class BasePage {
    protected AndroidDriver driver;
    private long waitTime = 15;

    public BasePage(AndroidDriver _driver) {
        this.driver = _driver;
    }

    public void waitUntilClickable(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitUntilVisible(AndroidElement element) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        wait.ignoring(NoSuchElementException.class, ElementNotVisibleException.class);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilInvisible(AndroidElement element) {
        int count = 30;
        try {
            while (!element.isDisplayed() || count == 0) {
                sleep(500);
                count--;
            }
        } catch (NoSuchElementException ignore) {

        }
    }

    public void sleep(long miliSeconds) {
        try {
            Thread.sleep(miliSeconds);
        } catch (Exception exception) {

        }
    }
}
