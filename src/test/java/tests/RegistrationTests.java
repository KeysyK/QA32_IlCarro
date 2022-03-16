package tests;

import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void regSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;

        app.getUserHelper().openRegForm();
        app.getUserHelper().fillRegFields("Arielle", "Cohen", "arielle"+index+"@gmail.com", "Arielle1234$");

        //WebElement checkBox = wd.findElement(By.cssSelector("#terms-of-use"));
    }
}
