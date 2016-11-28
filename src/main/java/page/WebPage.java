package page;

import browser.Browser;
import element.NavigationBar;
import test.CarsTest;
import wait.Waits;

public abstract class WebPage {

    private String url;
    public NavigationBar navigationBar;

    public WebPage(String url) {
        this.url = url;
        if (!url.equals(Browser.driver.getCurrentUrl())){
            open();
        }
        else{
            initElements();
        }
    }

    public WebPage(){
        this.url = Browser.driver.getCurrentUrl();
        initElements();
    }

    private void waitToLoad() {
        for(int i = 0; i < 100; i++) {
            Waits.waitAllJQueryRequest();
            Waits.waitAllJSRequests();
        }
    }

    private void initElements(){
        waitToLoad();
        navigationBar = new NavigationBar();
    }

    public void open() {
        Browser.openPage(url);
        initElements();
    }

}