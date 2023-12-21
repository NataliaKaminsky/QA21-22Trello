package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver driver;
    HelperUser helperUser;
    HelperBoard helperBoard;


    public void init() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://trello.com/home");
        helperUser = new HelperUser(driver);
        helperBoard = new HelperBoard(driver);

    }

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperBoard getHelperBoard() {
        return helperBoard;
    }

    public void stop() {
        driver.close();//close current window
        driver.quit();//close all tabs
    }
}
