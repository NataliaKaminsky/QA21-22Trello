package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        app.getHelperUser().login("natalia.kaminsky142857@gmail.com", "7Zhizney!");
        Assert.assertTrue(app.getHelperUser().isLogged());
    }


}
