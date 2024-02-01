package tests;

import manager.ApplicationManager;
import manager.TestNGListener;
import models.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import java.lang.reflect.Method;

@Listeners(TestNGListener.class)

public class TestBase {
    static ApplicationManager app = new ApplicationManager();

    Logger logger = LoggerFactory.getLogger(TestBase.class);
    UserDTO user = UserDTO.builder()
            .email("natalia.kaminsky142857@gmail.com")
            .password("7Zhizney!")
            .build();

    @BeforeSuite(alwaysRun = true)
    public void setup(){
        app.init();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown(){
        app.stop();
    }

}