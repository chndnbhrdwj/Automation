package apackage.dummy;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by chandank on 10/07/2017.
 */
public class BasePage {

    protected WebDriver driver;
    public static final int TINY_TIMEOUT = 3;
    public static final int SHORT_TIMEOUT = 5;
    public static final int LONG_TIMEOUT = 8;
    public static final int EXTRALONG_TIMEOUT = 10;
    public static final int TIMEOUT = 120;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTextElement(String text) {
        String locator = "";
        locator = "//*[@text=\"" + text
                + "\" or contains(@text,\"" + text
                + "\") or contains(@text,\"" + text.toUpperCase()
                + "\") or contains(text(),\"" + text
                + "\") or text()=\"" + text
                + "\" or contains(@content-desc,\"" + text
                + "\")]";
        return driver.findElement(By.xpath(locator));
    }

}

