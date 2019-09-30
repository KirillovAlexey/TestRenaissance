package Pages;

import steps.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public WebDriver driver = BaseStep.getDriver();

    public BasePage() {
        PageFactory.initElements(driver, this);
    }
}
