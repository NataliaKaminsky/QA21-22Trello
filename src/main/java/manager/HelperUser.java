package manager;

import models.UserDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperUser extends HelperBase{
    public HelperUser(WebDriver driver) {
        super(driver);
    }

    By buttonLogin = By.xpath("//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']");
    By inputLogin = By.cssSelector("#username");
    By inputPassword = By.cssSelector("#password");
    By buttonContinue = By.cssSelector("#login-submit");
    By buttonLoginSubmit = By.cssSelector("#login-submit");

    //By buttonHeaderMemberMenu = By.xpath("//button[@data-testid='header-member-menu-button']");

    By buttonLogout = By.xpath("//button[@data-testid='account-menu-logout']");

    By buttonLogoutSubmit = By.id("logout-submit");

    public void clickButtonLogin(){
        clickBase(buttonLogin);
    }

    public void login(String email, String password) {
        clickBase(buttonLogin);
        typeBase(inputLogin, email);
        clickBase(buttonContinue);
        typeBase(inputPassword, password);
        clickBase(buttonLoginSubmit);
    }

    public void loginDTO(UserDTO userDTO) {
        clickBase(buttonLogin);
        typeBase(inputLogin, userDTO.getEmail());
        clickBase(buttonContinue);
        typeBase(inputPassword, userDTO.getPassword());
        clickBase(buttonLoginSubmit);
    }

    public void logout(){
        clickBase(buttonHeaderMemberMenu);
        clickBase(buttonLogout);
        clickBase(buttonLogoutSubmit);
    }

    public boolean isLogged(){
        return isElementPresent(buttonHeaderMemberMenu);
    }
}