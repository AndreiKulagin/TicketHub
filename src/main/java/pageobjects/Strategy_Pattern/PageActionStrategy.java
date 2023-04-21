package pageobjects.Strategy_Pattern;

import org.openqa.selenium.WebDriver;

public interface PageActionStrategy {
    public void performAction(WebDriver driver);
}
