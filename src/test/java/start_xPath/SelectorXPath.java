package start_xPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorXPath {
    WebDriver driver;

    @BeforeClass
    public void preCondition() {
        driver = new ChromeDriver();
        driver.get("https://trello.com/home");
        System.out.println("Before class");
    }

    @Test(enabled = false)
    public void start() {
        System.out.println("Hi test1===================");
        WebElement elementLogin = driver.findElement(By.xpath(
                "//a[@data-uuid='MJFtCCgVhXrVl7v9HA7EH_login']"));
        System.out.println(elementLogin.getText());
        WebElement btnGetTrelloForFree = driver.findElement(
                By.xpath("//*[text()='Get Trello for free' and " +
                        "@data-uuid='MJFtCCgVhXrVl7v9HA7EH_signup']"));
        System.out.println(btnGetTrelloForFree.getAttribute("class"));
        WebElement textTrello = driver.findElement(By.xpath("//main[@id='skip-target']/section[@class='UiSectionstyles__Section-sc-4xxafg-0 cDvxpF ui-section']//h1"));
        System.out.println(textTrello.getText());
        WebElement section = driver.findElement(By.xpath("//main[@id='skip-target']/*[5]"));
        System.out.println(section.getAttribute("data-testid"));
        ////main[@id='skip-target']/*[5]//div[@class='FullWidthCarouselstyles__Controls-sc-16jty68-0 itOKSq']
        ////main[@id='skip-target']/*[5]//div[contains(@class,'Controls-sc-16jty68-0 itOKSq')]
        WebElement divContains = driver.findElement(By.xpath("//main[@id='skip-target']/*[5]//div[contains(@class,'Controls-sc-16jty68-0 itOKSq')]"));
        System.out.println(divContains.getAttribute("class"));
        WebElement parent = driver.findElement(By.xpath("//div[@class ='FullWidthCarouselstyles__ScrollBar-sc-16jty68-2 hQDEpm']/../../.."));
        System.out.println("id --> parent " + parent.getAttribute("id"));

        List<WebElement> webElementlist = driver.findElements(By.xpath("//*[@id='skip-target']/section"));
        System.out.println("List size = "+ webElementlist.size());

    }

    @Test(enabled = false)
    public void start1() {
        System.out.println("Hi test2===================");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("After class");
        driver.close();
    }


}
