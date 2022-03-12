package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @Test
    public void loginSuccess(){
        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
        type(By.cssSelector("#email"),"arielle@mail.ru");
        type(By.cssSelector("#password"), "Arielle1234$");
        click(By.xpath("//button[@type='submit']"));
        isElementPresent(By.cssSelector("[href='/logout?url=%2Fsearch']"));
    }
}
