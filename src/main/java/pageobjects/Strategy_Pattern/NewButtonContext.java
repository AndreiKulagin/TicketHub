package pageobjects.Strategy_Pattern;

import org.openqa.selenium.WebDriver;

public class NewButtonContext {
    private NewButtonClickStrategy strategy;

    public NewButtonContext(NewButtonClickStrategy strategy) {
        this.strategy = strategy;
    }

    public void newButtonClick(WebDriver driver) {
        strategy.newButtonClick(driver);
    }

    public void setStrategy(NewButtonClickStrategy strategy) {
        this.strategy = strategy;
    }
}