package page.car;

import browser.Browser;
import org.openqa.selenium.By;
import page.WebPage;

public class CarPage extends WebPage{

    public String carTitle;

    public CarPage(){
        carTitle = Browser.driver.findElement(By.className("cui-alpha")).getText();
    }

}