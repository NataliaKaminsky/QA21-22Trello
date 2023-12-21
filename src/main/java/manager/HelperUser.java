package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver driver) {
        super(driver);
    }

    By buttonLogin = By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");

    By inputLogin = By.cssSelector("#username");

    By buttonContinue = By.cssSelector("#login-submit");

    By inputPassword = By.cssSelector("#password");

    By buttonLoginSubmit = By.cssSelector("#login-submit");

    By buttonHeaderMemberMenu = By.xpath("//button[@data-testid='header-member-menu-button']");


    public void clickButtonLogin() {
        clickBase(buttonLogin);
    }

    public void login(String email, String password) {
        clickBase(buttonLogin);
        typeBase(inputLogin, email);
        clickBase(buttonContinue);
        typeBase(inputPassword, password);
        clickBase(buttonLoginSubmit);

    }

    public boolean isLogged(){
        return isElementPresent(buttonHeaderMemberMenu);
    }



}


