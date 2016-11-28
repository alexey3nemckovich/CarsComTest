package page.category;

import browser.Browser;
import element.Container;
import element.ContainerItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.WebPage;
import page.category.element.CarsContainer;

import java.util.List;

public class CarsCategoryPage extends WebPage{

    public CarsContainer carsContainer;

    public CarsCategoryPage(String url){
        super(url);
        carsContainer = new CarsContainer("gridView", "");
    }

}