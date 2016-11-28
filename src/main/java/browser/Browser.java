package browser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.By;

public class Browser {

    private static ChromeDriverService service;
    public static WebDriver driver;

    static {
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src\\main\\resources\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
    }

    public static void startService(){
        try {
            service.start();
        }catch (Exception e){

        }
    }

    public static void open() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void close(){
        driver.quit();
    }

    public static void stopService(){
        service.stop();
    }

    public static void maximizeWindow(){
        driver.manage().window().maximize();
    }

    public static void scrollPageToElement(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",element);
    }

    public static void vertialScrollPageWithOffset(int value){
        ((JavascriptExecutor)driver).executeScript("window.scrollBy(" + 0 + ","
                + value + ");");
    }

    public static void openPage(String url){
        driver.get(url);
    }

}