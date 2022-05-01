package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SearchHelper extends HelperBase{
    public SearchHelper(WebDriver wd) {
        super(wd);
    }

    public void typeLocation(String address) {
        type(By.id("city"), address);
        click(By.cssSelector(".pac-item"));
        pause(500);
    }

    public void dataPicker() {
        click(By.id("dates"));
        click(By.xpath("//div[text()=' 10 ']"));
        click(By.xpath("//div[text()=' 20 ']"));
        click(By.xpath("//button[@type='submit']"));

    }

    //public void typeDate() {
        //click(By.id("dates"));
        //click(By.className(".cdk-live-announcer-element cdk-visually-hidden"));
        //type(By.id("dates"),"4/1/2022 - 4/2/2022");
    //}

    public void selectPeriod(String dataFrom, String dataTo) {
        click(By.id("dates"));

        String[]from = dataFrom.split("/");
        String dayF = from[1];
        String locatorFrom = String.format("//div[text()=' %s ']",dayF);
        click(By.xpath(locatorFrom));

        String[] to = dataTo.split("/");
        String dayT = to[1];
        String locatorTo = String.format("//div[text()=' %s ']",dayT);
        click(By.xpath(locatorTo));
        click(By.xpath("//button[@type='submit']"));
        //click(By.className("navigation-link"));
    }

    public void searchAnyPeriod(String city, String dataFrom, String dataTo) {
        typeLocation(city);
        selectPeriodAnyData(dataFrom, dataTo);
    }

    private void selectPeriodAnyData(String dataFrom, String dataTo) {
        LocalDate now = LocalDate.now();
        LocalDate from = LocalDate.parse(dataFrom, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        LocalDate to = LocalDate.parse(dataTo, DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        click(By.id("dates"));
        int diffYear;
        int diffMonth;

        diffYear = from.getYear()- now.getYear();
        if(diffYear==0){
            diffMonth = from.getMonthValue()-now.getMonthValue();
        }else{
            diffMonth = 12-now.getMonthValue()+from.getMonthValue();
        }
        clickByNextMonth(diffMonth);

        String locator = String.format("//div[text()=' %s ']",from.getDayOfMonth());
        click(By.xpath(locator));
        //************************************************//

        diffYear = to.getYear()- from.getYear();
        if(diffYear==0) {
            diffMonth = to.getMonthValue() - from.getMonthValue();
        }else {
            diffMonth = 12 - from.getMonthValue() + to.getMonthValue();
        }
        clickByNextMonth(diffMonth);
        locator = String.format("//div[text()=' %s ']",to.getDayOfMonth());
        click(By.xpath(locator));
        //click(By.xpath("//button[@type='submit']"));
    }

    private void clickByNextMonth(int count){
        for (int i = 0; i < count ; i++) {
            click(By.xpath("//button[@aria-label='Next month']"));
        }
    }

    public void returnToHomePage() {
        pause(2000);
        click(By.className("logo"));
        takeScreenShot("C:/Users/keysy/Desktop/QA-32/QA32_IlCarro/src/test/screenshots/screenshot1.png");
    }
}

