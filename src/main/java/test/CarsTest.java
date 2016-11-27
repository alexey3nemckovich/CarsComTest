package test;

import element.SubMenu;
import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.main.MainPage;
import page.research.ResearchCarsPage;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class CarsTest extends TestCase {

    private static ChromeDriverService service;
    public static WebDriver driver;
    public static WebDriverWait driverWait;

    @BeforeClass
    public static void createAndStartService()
    throws IOException{
        service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("src\\main\\resources\\chromedriver.exe"))
                .usingAnyFreePort()
                .build();
        service.start();
    }

    @Before
    public void setUp() {
        driver = new RemoteWebDriver(service.getUrl(),
                DesiredCapabilities.chrome());
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driverWait = new WebDriverWait(driver, 60);
    }

    @Test
    public void testCars() {
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage("http:\\cars.com");
        SubMenu subMenu = mainPage.navigationBar.clickItem("Buy");
        subMenu.clickItem("Research Car Models");
        ResearchCarsPage researchCarsPage = new ResearchCarsPage(driver.getCurrentUrl());
        researchCarsPage.showCarTypesBtn.click();

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @AfterClass
    public static void createAndStopService() {
        service.stop();
    }

}