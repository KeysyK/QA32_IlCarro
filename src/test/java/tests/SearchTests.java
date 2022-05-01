package tests;

import models.User;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SearchTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        User user = new User().withEmail("arielle@mail.ru").withPassword("Arielle1234$");
        if(!app.getUserHelper().isLogOutPresent())
            app.getUserHelper().login(user);
        logger.info("Test start with user ---> " + user.toString());
    }

    @Test(enabled = false)
    public void searchCurrentMonth(){
        app.getSearchHelper().typeLocation("Tel Aviv");
        app.getSearchHelper().selectPeriod("4/10/2022","4/20/2022");
        }

    @Test
    public void searchAnyPeriod(){
        app.getSearchHelper().searchAnyPeriod("Tel Aviv", "04/20/2022", "04/01/2023");
        app.getSearchHelper().submit();

        }

    @AfterTest
    public void afterMethod(){
        app.getSearchHelper().returnToHomePage();
        }
    }

