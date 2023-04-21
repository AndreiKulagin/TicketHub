package pageobjects.Strategy_Pattern;

import org.openqa.selenium.WebDriver;

public class PageActionPerformer {
    private PageActionStrategy strategy;

    public PageActionPerformer(PageActionStrategy strategy) {
        this.strategy = strategy;
    }

    public void performAction(WebDriver driver) {
        strategy.performAction(driver);
    }

    public void setStrategy(PageActionStrategy strategy) {
        this.strategy = strategy;
    }
}