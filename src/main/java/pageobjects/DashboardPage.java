package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='menu-dashboard']")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//*[@id='company-additional-information'][1]")
    public WebElement companyAdditionalInformationButton;


    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

        public List<String> getAllTitlesWithCategoryDevelopment(){
        dashboardMenu.click();
        companyAdditionalInformationButton.click();

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='collapse1']/div/table/tbody/tr"));

        List<WebElement> filteredRows = rows.stream()
                .filter(row->row.findElement(By.xpath("//td[9]")).getText().equals("Разработка"))
                .collect(Collectors.toList());
        return filteredRows.stream()
                .map(row->row.findElement(By.xpath("//td[3]")).getText())
                .collect(Collectors.toList());

    }

    public List<String> getAllTitlesWithCategoryFinance(){
        dashboardMenu.click();
        companyAdditionalInformationButton.click();

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='collapse1']/div/table/tbody/tr"));

        List<WebElement> filteredRows = rows.stream()
                .filter(row->row.findElement(By.xpath("//td[9]")).getText().equals("Финансы"))
                .collect(Collectors.toList());
        return filteredRows.stream()
                .map(row->row.findElement(By.xpath("//td[3]")).getText())
                .collect(Collectors.toList());

    }

    public List<String> getAllIdsWithPriorityP3(){
        dashboardMenu.click();
        companyAdditionalInformationButton.click();

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='collapse1']/div/table/tbody/tr"));

        List<WebElement> filteredRows = rows.stream()
                .filter(row->row.findElement(By.xpath("//td[5]")).getText().equals("P3"))
                .collect(Collectors.toList());
        return filteredRows.stream()
                .map(row->row.findElement(By.xpath("//td[2]")).getText())
                .collect(Collectors.toList());
    }
}