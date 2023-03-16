package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DashboardPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[@id='menu-dashboard']")
    private WebElement dashboardMenu;

    @FindBy(xpath = "//*[@id='accordion7']/div")
    public WebElement companyAdditionalInformationButton;

    @FindBy(xpath ="//button[@id='dashboard-done']" )
    public WebElement dashboardDoneButton;


    public DashboardPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public List<String> getAllTitlesWithCategoryDevelopment() throws InterruptedException {

        dashboardMenu.click();
        Thread.sleep(2000);

        Actions actions = new Actions(driver);
        actions.moveToElement(dashboardDoneButton).perform();
        Thread.sleep(2000);

        dashboardDoneButton.click();
        Thread.sleep(2000);

        companyAdditionalInformationButton.click();
        Thread.sleep(2000);

        List<String> titles = new ArrayList<>();

        // Find all rows in the table
        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='collapse7']/div/table/tbody/tr"));

        // Loop through each row in the table
        for (WebElement row : rows) {
            // Get the Category value for this row
            String category = row.findElement(By.xpath("//td[9]")).getText();

            // If the Category is "Разработка", add the Title value to the list
            if (category.equals("Разработка")) {
                String title = row.findElement(By.xpath("//td[3]")).getText();
                titles.add(title);
                System.out.println(titles);
            }
        }

        return titles;
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