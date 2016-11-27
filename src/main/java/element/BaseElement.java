package element;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.CarsTest;

public abstract class BaseElement {

    private String elClass;
    private String elID;
    private By elBy;
    protected WebElement element;
    private static WebDriverWait driverWait;

    public BaseElement(String elID) {
        this(null, elID);
    }

    public  BaseElement(String elClass, String elID) {
        if(elClass == null) {
            elBy = By.id(elID);
        }
        else {
            if (elID != null) {
                elBy = By.xpath("//*[@id='"+ elID +"'][@class='"+ elClass +"']");
            }
            else{
                elBy = By.className(elClass);
            }
        }
        element = CarsTest.driver.findElement(elBy);
        driverWait = CarsTest.driverWait;
    }

    protected void waitToBeClickable() {
        driverWait.until(
                ExpectedConditions.elementToBeClickable(elBy)
        );
    }

    protected void waitToBeVisible(){
        driverWait.until(
                ExpectedConditions.visibilityOfElementLocated(elBy)
        );
    }

    public static void waitToBeClickable(WebElement element){
        driverWait.until(
                ExpectedConditions.elementToBeClickable(element)
        );
    }

    public static void waitToBeVisible(WebElement element) {
        driverWait.until(
                ExpectedConditions.visibilityOf(element)
        );
    }

    public String getElementText() {
        return element.getText();
    }

    public  void click() {
        waitToBeClickable();
        element.click();
    }

}