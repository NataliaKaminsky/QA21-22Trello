package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    //WebDriver driver;

    EventFiringWebDriver driver;
    HelperUser helperUser;

    HelperBoard helperBoard;

    HelperProfile helperProfile;

    public Logger logger = LoggerFactory.getLogger(ApplicationManager.class);

    String url = "https://trello.com/home";

    static String browser;

    public ApplicationManager() {
        browser = System.getProperty("browser", BrowserType.CHROME);
    }

    public void init() {
        //driver = new EventFiringWebDriver(new ChromeDriver());
        if (browser.equals(BrowserType.FIREFOX)) {
            driver = new EventFiringWebDriver(new FirefoxDriver());
            logger.info("created firefox driver");
        } else {
            driver = new EventFiringWebDriver(new ChromeDriver());
            logger.info("created chrome browser");
        }
        driver.register(new WDListener());
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);
        helperProfile = new HelperProfile(driver);

        logger.info("start testing -------------------------------> " + LocalDate.now());


    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperBoard getHelperBoard() {
        return helperBoard;
    }

    public HelperProfile getHelperProfile() {
        return helperProfile;
    }

    public void stop() {
        //driver.close();
        driver.quit();
        logger.info("stop testing --> " + LocalDate.now());
    }

}