package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WDListener extends AbstractWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(WDListener.class);

    public WDListener() {
        super();
    }


    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        super.beforeNavigateTo(url, driver);
        logger.info("navigate to --> " + url);
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        super.afterNavigateTo(url, driver);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        super.beforeNavigateBack(driver);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        super.afterNavigateBack(driver);
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        super.beforeNavigateForward(driver);
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        super.afterNavigateForward(driver);
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        super.beforeNavigateRefresh(driver);
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        super.afterNavigateRefresh(driver);
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        super.beforeFindBy(by, element, driver);
        logger.info("before find element: " + by);
    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        super.afterFindBy(by, element, driver);
        logger.info("after find element: " + by);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        super.beforeClickOn(element, driver);
        logger.info("start method click");
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        super.afterClickOn(element, driver);
        logger.info("done method click");
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.beforeChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        super.afterChangeValueOf(element, driver, keysToSend);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        super.beforeScript(script, driver);
        logger.info("start execute method js script --> " + script);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        super.afterScript(script, driver);
        logger.info("script execute ");
    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {
        super.afterSwitchToWindow(windowName, driver);
    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {
        super.beforeSwitchToWindow(windowName, driver);
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        super.onException(throwable, driver);
        String fileName = createFileNameScreenshot();
        logger.info("start on exception in WDListener class");
        logger.error(throwable.getMessage());
        logger.error(throwable.toString());
        logger.info("create screenshot with name --> " + fileName);
        takeScreenshot((TakesScreenshot) driver, fileName);
    }

    private String createFileNameScreenshot() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        //System.out.println(date);
        String curDate = formatter.format(date);
        //System.out.println(curDate);
        String fileName = curDate.replace(":", "-");
        //System.out.println(fileName);
        String filePath = "src/test_logs/screenshots/screenshot_" + fileName + ".png";
        return filePath;
    }

    private void takeScreenshot(TakesScreenshot screenshot, String filePath) {

        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
//        Date date = new Date(System.currentTimeMillis());
//        //System.out.println(date);
//        String curDate = formatter.format(date);
//        //System.out.println(curDate);
//        String fileName = curDate.replace(":", "-");
//        //System.out.println(fileName);
//        String filePath = "src/test_logs/screenshots/screnshot_" + fileName + ".png";

        File destFile = new File(filePath);
        try {
            Files.copy(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {
        super.beforeGetScreenshotAs(target);
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
        super.afterGetScreenshotAs(target, screenshot);
    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {
        super.beforeGetText(element, driver);
    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {
        super.afterGetText(element, driver, text);
    }
}