package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class RegistrationTests extends TestBase{

    @Test
    public void regSuccess(){
        click(By.cssSelector("[href='/registration?url=%2Fsearch']"));
        type(By.cssSelector("#name"),"Arielle");
        type(By.cssSelector("#lastName"), "Cohen");
        type(By.cssSelector("#email"), "arielle@gmail.com");
        type(By.cssSelector("#password"), "Arielle1234$");

        WebElement checkBox = wd.findElement(By.cssSelector("#terms-of-use"));
    }
}
