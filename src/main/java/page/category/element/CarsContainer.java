package page.category.element;

import element.Container;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CarsContainer extends Container{

    public List<CarsContainerItem> carItems;

    public CarsContainer(String elClass, String elID){
        super(elClass, elID);
        carItems = new ArrayList<CarsContainerItem>();
        List<WebElement> carItemEls = element.findElements(By.className("result-card"));
        for (WebElement carItemEl:
             carItemEls) {
            CarsContainerItem carItem = new CarsContainerItem(carItemEl);
            if(carItem.carPageHref != null){
                carItems.add(carItem);
            }
        }
    }

}