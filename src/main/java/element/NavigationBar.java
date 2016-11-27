package element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NavigationBar extends BaseElement implements Menu {

    public NavigationBar() {
        super("navbar-list" , null);
    }

    public SubMenu clickItem(String item) {
        waitToBeVisible();
        WebElement navItem = element.findElement(By.linkText(item));
        BaseElement.waitToBeClickable(navItem);
        navItem.click();
        return new SubMenu();
    }

}