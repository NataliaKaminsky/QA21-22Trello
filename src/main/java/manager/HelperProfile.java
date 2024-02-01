package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class HelperProfile extends HelperBase{
    public HelperProfile(WebDriver driver) {
        super(driver);
    }

    By buttonManageAccount = By.xpath("//a[@data-testid='manage-account-link']");

    By textProfileAndVisibility = By.xpath("//h1");

    By profilePhoto = By.xpath("//div[@data-test-selector='profile-hover-info']");

    By buttonChangeProfile = By.xpath("//button[@data-testid='change-avatar']");

    By buttonUploadPhoto = By.id("image-input");

    By buttonUpload = By.xpath("//button[@type='submit']");

    //================================================================
    By popUpAvatarAdded = By.xpath("//span[text()='Avatar added']");

    By buttonTryAgain = By.id("padded-break"); //Try again

    By buttonCansel = By.xpath("//span[text()='Cancel']/..");
    public void changeAvatar() {
        clickBase(buttonHeaderMemberMenu);
        clickBase(buttonManageAccount);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(textProfileAndVisibility,"Profile and visibility"));
        clickBase(profilePhoto);
        clickBase(buttonChangeProfile);
        //pause(5);
        File file = new File("src/test/resources/qa_blue.jpg");
        String absolutePath = file.getAbsolutePath();
        System.out.println("absolute path --> "+absolutePath);  //C:\QA_Auto_Projects\QA_21_22\QA21-22_Trello\src\test\resources\qa_yellow.png
        driver.findElement(buttonUploadPhoto)
                .sendKeys(absolutePath); //add photo
        clickBase(buttonUpload);
        System.out.println("--> "+driver.findElement(buttonUpload).getCssValue("text-align"));

    }

    public void returnToHomePage(){
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.close();
        driver.switchTo().window(tabs.get(0));
    }

    public boolean isTextInElementPresentByWait_Avatar_added(){
        return isTextInElementPresentByWait(popUpAvatarAdded, "Avatar added", 5);
    }

    public void changeAvatarNegative_txtFile() {
        clickBase(buttonHeaderMemberMenu);
        clickBase(buttonManageAccount);
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElementLocated(textProfileAndVisibility,"Profile and visibility"));
        clickBase(profilePhoto);
        clickBase(buttonChangeProfile);
        //pause(5);
        File file = new File("src/test/resources/txt_for_qa.txt");
        String absolutePath = file.getAbsolutePath();
        //System.out.println("absolute path --> "+absolutePath);  //C:\QA_Auto_Projects\QA_21_22\QA21-22_Trello\src\test\resources\qa_yellow.png
        driver.findElement(buttonUploadPhoto)
                .sendKeys(absolutePath); //add photo
    }

    public  boolean isTextInElementPreset_Try_again(){
        return isTextInElementPresentByWait(buttonTryAgain,"Try again", 5);
    }

    public void clickCansel(){
        clickBase(buttonCansel);
    }


}