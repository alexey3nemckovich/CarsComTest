package element;

import org.openqa.selenium.WebElement;

public class ContainerItem extends BaseElement{

    public ContainerItem(Container parent, String linkText){
        super((BaseElement) parent, linkText);
    }

    public ContainerItem(WebElement element){super(element);}

}