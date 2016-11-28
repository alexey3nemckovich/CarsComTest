package element;

import browser.Browser;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.CarsTest;
import wait.Waits;

public abstract class BaseElement {

    public WebElement element;

    public BaseElement(WebElement element){
        this.element = element;
    }

    public BaseElement(BaseElement parent, String linkText){
        element = parent.element.findElement(
                By.linkText(linkText)
        );
    }

    public  BaseElement(String elClass, String elID) {
        By elBy;
        if(elClass.equals("")) {
            elBy = By.id(elID);
        }
        else {
            if (!elID.equals("")) {
                elBy = By.xpath("//*[@id='"+ elID +"'][@class='"+ elClass +"']");
            }
            else{
                elBy = By.className(elClass);
            }
        }
        element = Browser.driver.findElement(elBy);
    }

    public String getElementText() {
        return element.getText();
    }

    public void click() {
        Waits.waitElementToBeClickable(element);
        element.click();
        Waits.waitAllJSRequests();
        Waits.waitAllJQueryRequest();
    }

}