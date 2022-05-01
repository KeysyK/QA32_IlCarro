package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    //WebDriver wd;
    EventFiringWebDriver wd;
    String browser;
    UserHelper userHelper;
    CarHelper carHelper;
    SearchHelper searchHelper;
    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init(){
        if(browser.equals(BrowserType.CHROME)) {
            wd = new EventFiringWebDriver(new ChromeDriver());
            logger.info("All tests start in ChromeDriver");
        }else if(browser.equals(BrowserType.FIREFOX)){
            wd = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("All tests start in FireFox");
        }

        logger.info("All tests start in ChromeDriver");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.navigate().to("https://ilcarro.xyz/");
        userHelper = new UserHelper(wd);
        carHelper = new CarHelper(wd);
        searchHelper = new SearchHelper(wd);

        wd.register(new MyListener());
    }

    public void stop(){
        //wd.quit();
    }

    public UserHelper getUserHelper() {
        return userHelper;
    }

    public CarHelper getCarHelper() {
        return carHelper;
    }

    public SearchHelper getSearchHelper() {
        return searchHelper;
    }
}
