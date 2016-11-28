package page.category.element;

import browser.Browser;
import element.ContainerItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wait.Waits;

public class CarsContainerItem extends ContainerItem{

    public String carTitle;
    public String carPageHref;

    public CarsContainerItem(WebElement element){
        super(element);
        WebElement titleEl = element.findElement(By.className("cardTitle"));
        carTitle = titleEl.getText();
        carPageHref = titleEl.findElement(By.xpath("..")).getAttribute("href");
    }

    public void click(){
        Browser.driver.get(carPageHref);
        Waits.waitAllJSRequests();
        Waits.waitAllJQueryRequest();
    }

}