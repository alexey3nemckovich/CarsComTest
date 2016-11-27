package page;

import element.NavigationBar;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.CarsTest;

public abstract class WebPage {

    private static ExpectedCondition<Boolean> waitJSToLoadCondition;
    private static ExpectedCondition<Boolean> waitJQueryToLoadCondition;
    private static WebDriverWait driverWait;
    //private String url;
    public NavigationBar navigationBar;

    {
        driverWait = CarsTest.driverWait;
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

    public WebPage(String url) {
        if (!url.equals(CarsTest.driver.getCurrentUrl())){
            open(url);
        }
        else{
            setUrl(url);
        }
    }

    private void waitToLoad() {
        driverWait.until(
                waitJSToLoadCondition
        );
    }

    private void setUrl(String url){
        waitToLoad();
        //this.url = url;
        navigationBar = new NavigationBar();
    }

    private void open(String url) {
        CarsTest.driver.get(url);
        setUrl(url);
    }

}