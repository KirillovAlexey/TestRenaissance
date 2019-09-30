package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.function.Function;

public class DepositPage extends BasePage{
    @FindBy(xpath = "//span[contains(text(),'Рубли')]//..//..//input[@type='radio']")
    WebElement rur;
    @FindBy(xpath = "//input[@name='amount']")
    WebElement sumDeposit;
    @FindBy(xpath = "//div[@class='jq-selectbox__select']//..//ul//li")
    List<WebElement> list;
    @FindBy(xpath = "//input[@name='replenish']")
    WebElement addPriceToMounth;
    @FindBy(xpath = "//span[contains(text(),'Ежемесячная капитализация')]//..//..//div[@class='jq-checkbox calculator__check']")
    WebElement checkBoxCapitilize;
    @FindBy(xpath = "//span[contains(text(),'Частичное снятие')]//..//..//div[@class='jq-checkbox calculator__check']")
    WebElement checkBoxTakeMyMoney;

    @FindBy(xpath = "//span[@class='js-calc-amount']")
    WebElement amount;

    public void insertDate(){
        waitingChange(sumDeposit,"300000");

        for (WebElement webElement: list) {
            if(webElement.getAttribute("textContent").equals("6 месяцев")){
                driver.findElement(By.xpath("//div[@class='jq-selectbox__select-text']")).click();
                webElement.click();
            }
        }

        waitingChange(addPriceToMounth,"50000");

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement((By) checkBoxTakeMyMoney));
        checkBoxTakeMyMoney.click();
        //checkBoxTakeMyMoney.click();
    }

    public void waitingChange(WebElement element, String text) {

        Function<? super WebDriver, Object> valueChanged = (ExpectedCondition<Object>) webDriver -> {
            String newValue = amount.getText();
            return newValue.replace(" ","").equals(text);
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
        fillsArea(element, text);
        wait.until(valueChanged);
    }

    public void fillsArea(WebElement element,String text){
        element.clear();
        element.sendKeys(text);
    }
}
