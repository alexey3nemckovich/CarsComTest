package page.research;

import page.WebPage;
import page.research.element.*;

public class ResearchCarsPage extends WebPage {

    public ShowCarTypesBtn showCarTypesBtn;
    public CarTypesContainer carTypesContainer;

    public ResearchCarsPage(){
        showCarTypesBtn = new ShowCarTypesBtn();
        carTypesContainer = new CarTypesContainer();
    }

}