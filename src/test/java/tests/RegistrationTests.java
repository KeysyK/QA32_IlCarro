package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        if(app.getUserHelper().isLogOutPresent()){
            app.getUserHelper().logout();
        }
    }

    @Test(groups = {"flow","smoke"})
    public void regSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;

        app.getUserHelper().openRegForm();
        app.getUserHelper().fillRegFields("Arielle", "Cohen", "arielle"+index+"@gmail.com", "Arielle1234$");
        //app.getUserHelper().checkPolicy();
        app.getUserHelper().checkPolicyXY();
        app.getUserHelper().submit();
        Assert.assertEquals(app.getUserHelper().checkMessage(), "You are logged in success");
    }
    @Test
    public void regSuccessModel(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        User user = new User().withName("Arielle").withLastName("Cohen").withEmail("arielle"+index+"@gmail.com").withPassword("Arielle1234$");

        app.getUserHelper().openRegForm();
        app.getUserHelper().fillRegFields(user);
        app.getUserHelper().checkPolicyXY();
        app.getUserHelper().submit();
        Assert.assertEquals(app.getUserHelper().checkMessage(), "You are logged in success");
    }
    @Test
    public void regWrongPasswordModel(){
        User user = new User().withName("Arielle").withLastName("Cohen").withEmail("arielli@gmail.com").withPassword("12345");

        app.getUserHelper().openRegForm();
        app.getUserHelper().fillRegFields(user);
        app.getUserHelper().checkPolicy();
        //error + button not active
        Assert.assertTrue(app.getUserHelper().isErrorPasswordDisplayedSize());
        Assert.assertTrue(app.getUserHelper().isErrorPasswordDisplayedFormat());
        Assert.assertFalse(app.getUserHelper().isYallaButtonNotActive());
        Assert.assertTrue(app.getUserHelper().isYallaButtonDisabled());

    }
   @AfterMethod(alwaysRun = true)
   public void postCondition(){app.getUserHelper().submitOkButton();}
}
