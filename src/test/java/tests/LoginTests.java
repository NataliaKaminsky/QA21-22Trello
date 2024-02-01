package tests;

import manager.TestNGListener;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
@Listeners(TestNGListener.class)

public class LoginTests extends TestBase{

    @Test(enabled = false)
    public void loginPositiveTest(Method method){

        long startTime = System.currentTimeMillis();
        //app.getHelperUser().login("natalia.kaminsky142857@gmail.com","7Zhizney!");
        app.getHelperUser().login(user.getEmail(), user.getPassword());
        logger.info("method --> " +method.getName()+" email --> "+user.getEmail()+" password --> "+user.getPassword());
       //app.getHelperUser().takeScreenshot();
        logger.info("method duration --> "+(System.currentTimeMillis()-startTime));
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
}