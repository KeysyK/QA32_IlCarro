package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void fillLoginUser(User user) {
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
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
    public void fillRegFields(User user) {
        type(By.cssSelector("#name"), user.getName());
        type(By.cssSelector("#lastName"), user.getLastName());
        type(By.cssSelector("#email"), user.getEmail());
        type(By.cssSelector("#password"), user.getPassword());
    }

    public String checkMessage() {
        new WebDriverWait(wd, 5).until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector(".dialog-container h2"))));
        String message = wd.findElement(By.cssSelector(".dialog-container h2")).getText();
        System.out.println(message);
        return message;
    }
    public void submitOkButton(){
        if(isElementPresent(By.xpath("//button[text()='Ok']"))) {
            click(By.xpath("//button[text()='Ok']"));
        }
    }

    public boolean isLogOutPresent() {
        return isElementPresent(By.xpath("//a[text() =' Logout ']"));
    }

    public void logout() {
        click(By.xpath("//a[text() =' Logout ']"));
    }

    public void checkPolicy() {
        click(By.cssSelector("label[for='terms-of-use']"));
    }

    public void checkPolicyXY() {
        WebElement label = wd.findElement(By.cssSelector("label[for='terms-of-use']"));
        Rectangle rect = label.getRect();
        int offSetX = rect.getWidth()/2;
        int offSetY = rect.getHeight()/2;
        Actions actions = new Actions(wd);
        actions.moveToElement(label).release().perform();
        actions.moveByOffset(-offSetX,-offSetY).click().release().perform();
    }

    public boolean isErrorPasswordDisplayedSize() {
        Boolean firstChild = new WebDriverWait(wd,10).until(ExpectedConditions.textToBePresentInElement
                (wd.findElement(By.cssSelector("div.error div:first-child")),
                        "Password must contain minimum 8 symbols"));
        return firstChild;
    }
    public boolean isErrorPasswordDisplayedFormat(){
        Boolean lastChild = new WebDriverWait(wd,10).until(ExpectedConditions.textToBePresentInElement
                (wd.findElement(By.cssSelector("div.error div:last-child")),
                        "Password must contain 1 uppercase letter, 1 lowercase letter and one number"));
        return lastChild;


    }

    public boolean isYallaButtonNotActive() {
        return wd.findElement(By.cssSelector("[type='submit']")).isEnabled();
   }

    public boolean isYallaButtonDisabled() {
        return isElementPresent(By.cssSelector("button[disabled]"));
    }

    public void login(User user) {
        openLoginForm();
        fillLoginUser(user);
        submit();
        submitOkButton();
    }
}
