package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SubMenu extends BaseElement implements Menu {

    public SubMenu() {
        super("submenu-container", null);
    }

    public Object clickItem(String itemName) {
        waitToBeVisible();
        WebElement sumItem = element.findElement(By.linkText(itemName));
        BaseElement.waitToBeClickable(sumItem);
        sumItem.click();
        return null;
    }

}