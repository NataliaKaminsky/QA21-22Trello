package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HelperBase {

    WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement findElementBase(By locator) {
        System.out.println(locator);
        return driver.findElement(locator);
    }

    private List<WebElement> findElementsBase(By locator) {
        System.out.println(locator);
        return driver.findElements(locator);
    }

    public void pause(int time) {
        try {
            Thread.sleep(time * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void clickBase(By locator) {
        WebElement element = findElementBase(locator);
        element.click();
        // findElementBase(locator).click();
    }

    public void typeBase(By locator, String text) {
        WebElement element = findElementBase(locator);
        element.click();
        element.click();
        element.sendKeys(text);
    }

    public boolean isElementPresent(By locator) {//return list.size()>0
        return !findElementsBase(locator).isEmpty();
    }

    public boolean isTextInElementEqual(By locator, String text){
        WebElement element = findElementBase(locator);
        return element.getText().equals(text);
    }
}
