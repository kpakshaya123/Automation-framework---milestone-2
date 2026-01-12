package orangehrm.utility;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class WaitUtil {

    private static final int DEFAULT_TIMEOUT = 10;

    private static WebDriverWait getWait(WebDriver driver, int timeout) {
        return new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
    
 // WebElement visibility
    public static WebElement waitForVisibility(
            WebDriver driver, WebElement element) {

        return getWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    // WebElement clickable
    public static WebElement waitForClickable(
            WebDriver driver, WebElement element) {

        return getWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }


    // Wait till element visible
    public static WebElement waitForVisibility(
            WebDriver driver, By locator) {

        return getWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait till element clickable
    public static WebElement waitForClickable(
            WebDriver driver, By locator) {

        return getWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Wait for title
    public static boolean waitForTitle(
            WebDriver driver, String title) {

        return getWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.titleContains(title));
    }

    // Wait for URL
    public static boolean waitForUrl(
            WebDriver driver, String fraction) {

        return getWait(driver, DEFAULT_TIMEOUT)
                .until(ExpectedConditions.urlContains(fraction));
    }

    // Custom wait time
    public static WebElement waitForVisibility(
            WebDriver driver, By locator, int timeout) {

        return getWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}

