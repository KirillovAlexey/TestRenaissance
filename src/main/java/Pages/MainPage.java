package Pages;

import io.qameta.allure.Step;
import steps.BaseStep;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends BasePage {
    @FindBy(xpath = "//span[contains(text(),'Открыть вклад')]//..")
    WebElement deposit;

    WebDriver driver = BaseStep.getDriver();

    @Step("Открытие вклада в банке")
    public void openDepositPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10, 750);
        deposit.click();
    }
}
