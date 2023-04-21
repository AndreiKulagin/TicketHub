package tests.Strategy_Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageobjects.Strategy_Pattern.*;

public class Strategy_Pattern {
    public void strategyPattern() {
        WebDriver driver = new ChromeDriver();
        String currentPage = driver.getCurrentUrl();
        String ticketsPageURL = "http://176.36.27.131:8180/#/tickets?page=0&size=10&sort=&stage=&category=-1";
        String companiesPageURL = "http://176.36.27.131:8180/#/companies";
        String contactsPageURL = "http://176.36.27.131:8180/#/contacts";
        String devicesPageURL = "http://176.36.27.131:8180/#/device-list";
        PageActionPerformer performer = null;

        if (currentPage.equals(ticketsPageURL)) {
            performer = new PageActionPerformer(new TicketsPageActionStrategy());
        } else if (currentPage.equals(companiesPageURL)) {
            performer = new PageActionPerformer(new CompaniesPageActionStrategy());
        } else if (currentPage.equals(contactsPageURL)) {
            performer = new PageActionPerformer(new ContactsPageActionStrategy());
        } else if (currentPage.equals(devicesPageURL)) {
            performer = new PageActionPerformer(new DevicesPageActionStrategy());
            performer.performAction(driver);
        }
    }
}