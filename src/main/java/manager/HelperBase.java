package manager;


import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HelperBase {
    WebDriver driver;

    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }
    By buttonHeaderMemberMenu = By.xpath("//button[@data-testid='header-member-menu-button']");

    private WebElement findElementBase(By locator){
        //System.out.println(locator);
        //logger.info("find element --> "+locator);
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator){
        //System.out.println(locator);
        return driver.findElements(locator);
    }

    public void pause(int time){
        try {
            Thread.sleep(time* 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            logger.info("used method pause with time -->"+time+" sec");
        }
    }

    public void clickBase(By locator){
        WebElement element = findElementBase(locator);
        element.click();
    }

    public void clickBaseWait(By locator, int time){
        WebDriverWait wait = new WebDriverWait(driver, time);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void typeBase(By locator, String text){
        WebElement element = findElementBase(locator);
        element.click();
        element.clear();
        element.sendKeys(text);
    }

    public boolean isElementPresent(By locator){       //return list.size() > 0
        return !findElementsBase(locator).isEmpty();
    }

    public boolean isTextInElementEquals(By locator, String text){
        WebElement element = findElementBase(locator);
        return element.getText().equals(text);
    }
    public  boolean isTextInElementPresentByWait(By locator, String text, int time){
        try {
            new WebDriverWait(driver, time)
                    .until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
            return true;
        }catch (Exception e){
            return false;
        }

    }

//    public void takeScreenshot(){
//        TakesScreenshot screenshot = ((TakesScreenshot) driver);
//        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
//
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());
//        //System.out.println(date);
//        String curDate = formatter.format(date);
//        //System.out.println(curDate);
//        String fileName = curDate.replace(":","-");
//        //System.out.println(fileName);
//        String filePath = "src/test_logs/screenshots/screnshot_" + fileName + ".png";
//
//        File destFile = new File(filePath);
//        try {
//            Files.copy(srcFile, destFile);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }

}