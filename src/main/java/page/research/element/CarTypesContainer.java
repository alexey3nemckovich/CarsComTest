package page.research.element;

import browser.Browser;
import element.Container;
import element.ContainerItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import wait.Waits;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarTypesContainer extends Container{

    List<ContainerItem> carTypes;

    public CarTypesContainer(){
        super("body-style-tab", "");
    }

    public String getRandomCarTypePageUrl(){
        List<WebElement> carTypes = element.findElements(By.tagName("cars-grid-item"));
        WebElement carType = carTypes.get(new Random().nextInt(carTypes.size()));
        String carTypePageUrl = carType.getAttribute("href");
        if(carTypePageUrl.charAt(0) == '.') {
            carTypePageUrl = "http:\\cars.com" + carTypePageUrl.substring(2);
        }
        else{
            carTypePageUrl = "http:\\cars.com" + carTypePageUrl;
        }
        return carTypePageUrl;
    }

}