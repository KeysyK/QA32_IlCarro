package tests;

import models.Car;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewCarTests extends TestBase{
    @BeforeMethod(alwaysRun = true)
    public void preCondition(){
        User user = new User().withEmail("arielle@mail.ru").withPassword("Arielle1234$");
        if(!app.getUserHelper().isLogOutPresent())
            app.getUserHelper().login(user);
        logger.info("Test start with user ---> " + user.toString());
    }

    @Test(groups = {"flow"})
    public void addNewCarSuccess(){
        int index = (int)(System.currentTimeMillis()/1000)%3600;
        Car car = Car.builder()
                .address("Tel Aviv")
                .make("BMW")
                .model("M5")
                .year("2022")
                .engine("2.5")
                .fuel("Petrol")
                .gear("MT")
                .wD("AWD")
                .doors("5")
                .seats("8")
                .carClass("C")
                .fuelConsumption("6.5")
                .carRegNumber("110-12"+index)
                .price("65")
                .distanceIncluded("500")
                .features("Screen, USB")
                .about("Family car")
                .build();
        app.getCarHelper().openCarForm();
        app.getCarHelper().fillCarForm(car);
        app.getCarHelper().attachPhoto("C:/Users/keysy/Desktop/QA-32/QA32_IlCarro/src/test/resources/jpegsystems-home.jpg");
        app.getCarHelper().submit();

        Assert.assertTrue(app.getCarHelper().isCarAdded());
    }
}
