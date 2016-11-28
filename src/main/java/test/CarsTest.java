package test;

import browser.Browser;
import element.ContainerItem;
import element.SubMenu;
import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.JavascriptExecutor;
import page.car.CarPage;
import page.category.CarsCategoryPage;
import page.category.element.CarsContainerItem;
import page.main.MainPage;
import page.research.ResearchCarsPage;
import page.research.element.CarTypesContainer;

import java.util.List;

@RunWith(JUnit4.class)
public class CarsTest extends TestCase {

    @BeforeClass
    public static void beforeClass(){
        Browser.startService();
    }

    @Before
    public void setUp() {
        Browser.open();
    }

    @Test
    public void testCars() {
        Browser.maximizeWindow();
        MainPage mainPage = new MainPage("http:\\cars.com");
        mainPage.navigationBar.clickItem("Buy");
        new SubMenu().clickItem("Research Car Models");
        ResearchCarsPage researchCarsPage = new ResearchCarsPage();
        researchCarsPage.showCarTypesBtn.click();
        Browser.vertialScrollPageWithOffset(400);
        String carTypePageUrl = researchCarsPage.carTypesContainer.getRandomCarTypePageUrl();
        CarsCategoryPage carsCategoryPage = new CarsCategoryPage(carTypePageUrl);
        List<CarsContainerItem> carsContainerItems = carsCategoryPage.carsContainer.carItems;
        int scrollVal = 150;
        for (CarsContainerItem carItem:
             carsContainerItems) {
            Browser.vertialScrollPageWithOffset(scrollVal);
            carItem.click();
            CarPage carPage = new CarPage();
            Assert.assertEquals(carItem.carTitle, carPage.carTitle);
            carsCategoryPage.open();
            scrollVal += 150;
        }
    }

    @After
    public void tearDown() {
        Browser.close();
    }

    @AfterClass
    public static void createAndStopService() {
        Browser.stopService();
    }

}