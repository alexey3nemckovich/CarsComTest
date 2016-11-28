package wait;

import browser.Browser;
import element.BaseElement;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

    private static WebDriverWait driverWait;
    private static ExpectedCondition<Boolean> waitJSToLoadCondition;
    private static ExpectedCondition<Boolean> waitJQueryToLoadCondition;

    static {
        driverWait = new WebDriverWait(Browser.driver, 30);
        waitJSToLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webD) {
                Object scriptRes = ((JavascriptExecutor) webD).executeScript("return document.readyState");
                return scriptRes.equals("complete");
            }
        };
        waitJQueryToLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver webD) {
                try {
                    return ((Long)((JavascriptExecutor)webD).executeScript("return jQuery.active") == 0);
                }
                catch (Exception e) {
                    // no jQuery present
                    return true;
                }
            }
        };
    }

    public static void waitAllJSRequests() {
        driverWait.until(
                waitJSToLoadCondition
        );
    }

    public static void waitAllJQueryRequest() {
        driverWait.until(
                waitJQueryToLoadCondition
        );
    }

    public static void waitElementToBeClickable(WebElement element){
        driverWait.until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }

    public static void waitElementToBeVisible(WebElement element){
        driverWait.until(
                ExpectedConditions.visibilityOf(element)
        );
    }

}