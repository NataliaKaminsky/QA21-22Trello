package tests;

import manager.TestNGListener;
import models.UserDTO;
import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;
@Listeners(TestNGListener.class)

public class ProfileTests extends TestBase{


    @BeforeClass(alwaysRun = true)
    public void login() {
        logger.info("login with email --> " + user.getEmail() + " password --> " + user.getPassword());
        app.getHelperUser().loginDTO(user);
    }

    @Test(groups = {"smoke","positive"})
    public void changeAvatarPositiveTest(Method method){
        //logger.info("start method --> "+method.getName());
        app.getHelperProfile().changeAvatar();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPresentByWait_Avatar_added());
    }

    @Test(groups = {"negative"})
    public void changeAvatarNegativeTest_txtFile(Method method){
        //logger.info("start method --> "+method.getName());
        app.getHelperProfile().changeAvatarNegative_txtFile();
        Assert.assertTrue(app.getHelperProfile().isTextInElementPreset_Try_again());
    }

    @AfterMethod(alwaysRun = true)
    public void afterTest(){
        logger.info("start after method ------------------------------");
        if(app.getHelperProfile().isTextInElementPreset_Try_again())
            app.getHelperProfile().clickCansel();
        app.getHelperProfile().returnToHomePage();
        logger.info("stop after method ------------------------------");
    }

    @AfterClass(alwaysRun = true)
    public void logout(){
        app.getHelperUser().logout();
    }
}