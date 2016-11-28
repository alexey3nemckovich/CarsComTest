package element;

import wait.Waits;

public abstract class Container extends BaseElement{

    public Container(String elClass, String elID){
        super(elClass, elID);
    }

    public void clickItem(String itemText){
        Waits.waitElementToBeVisible(element);
        ContainerItem resCarModelsItem = new ContainerItem(this, itemText);
        resCarModelsItem.click();
    }

}