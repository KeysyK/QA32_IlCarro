package tests;

import manager.MyDataProvider;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void preCondition(){
        if(app.getUserHelper().isLogOutPresent()){
            app.getUserHelper().logout();
            logger.info("Test needs logout");
        }
    }
    @Test
    public void loginSuccess(){
        logger.info("The test starts with data [arielle@mail.ru] & [Arielle1234$]");
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("arielle@mail.ru","Arielle1234$");
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }
    @Test
    public void loginSuccessModel(){
        User user = new User().withEmail("arielle@mail.ru").withPassword("Arielle1234$");

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginUser(user);
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }
    @Test
    public void loginSuccessNew(){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm("arielle@mail.ru","Arielle1234$");
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }
    @Test(dataProvider = "validLoginData", dataProviderClass = MyDataProvider.class)
    public void loginSuccess(String email, String password){

        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginForm(email,password);
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }
    @Test(dataProvider = "validModelLogin", dataProviderClass = MyDataProvider.class)
    public void loginSuccessModel(User user){
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginUser(user);
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }
    @Test(dataProvider = "validLoginCsv", dataProviderClass = MyDataProvider.class)
    public void loginSuccess(User user) {
        app.getUserHelper().openLoginForm();
        app.getUserHelper().fillLoginUser(user);
        app.getUserHelper().submit();
        app.getUserHelper().pause(1000);
        Assert.assertEquals(app.getUserHelper().checkMessage(), "Logged in success");
    }
    @AfterMethod
    public void postCondition(){
        app.getUserHelper().submitOkButton();
    }
}
