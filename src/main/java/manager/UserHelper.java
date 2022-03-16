package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends HelperBase{
    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void openLoginForm() {
        click(By.cssSelector("[href='/login?url=%2Fsearch']"));
    }

    public void fillLoginForm(String email, String password) {
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }

    public void submitLogin() {
        click(By.xpath("//button[@type='submit']"));
    }

    public boolean isLoginSuccess() {
        return isElementPresent(By.cssSelector("[href='/logout?url=%2Fsearch']"));
    }

    public void openRegForm() {
        click(By.cssSelector("[href='/registration?url=%2Fsearch']"));
    }

    public void fillRegFields(String name, String lastname, String email, String password) {
        type(By.cssSelector("#name"),name);
        type(By.cssSelector("#lastName"), lastname);
        type(By.cssSelector("#email"), email);
        type(By.cssSelector("#password"), password);
    }
}
