package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("arielle@mail.ru","Arielle1234$");
        app.getUserHelper().submitLogin();
        Assert.assertTrue(app.getUserHelper().isLoginSuccess());
    }
}
