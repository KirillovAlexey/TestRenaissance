package Pages;

import io.qameta.allure.Step;
import org.junit.Assert;
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

public class DepositPage extends BasePage {
    @FindBy(xpath = "//div[@class='calculator__currency-content']//input//..//span[@class='calculator__currency-field-text']")
    List<WebElement> money;
    @FindBy(xpath = "//input[@name='amount']")
    WebElement sumDeposit;
    @FindBy(xpath = "//div[@class='jq-selectbox__dropdown']//ul//li")
    List<WebElement> list;
    @FindBy(xpath = "//input[@name='replenish']")
    WebElement addPriceToMounth;

    @FindBy(xpath = "//span[contains(text(),'Ежемесячная капитализация')]//..//..//div[@class='jq-checkbox calculator__check']")
    WebElement checkBoxCapitilize;
    @FindBy(xpath = "//span[contains(text(),'Частичное снятие')]//..//..//div[@class='jq-checkbox calculator__check']")
    WebElement checkBoxTakeMyMoney;

    @FindBy(xpath = "//span[@class='js-calc-rate']")
    WebElement percent;
    @FindBy(xpath = "//span[@class='js-calc-result']")
    WebElement totalMoney;
    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    WebElement moneyFor6Mounth;
    @FindBy(xpath = "//span[@class='js-calc-earned']")
    WebElement moneyProcentel;

    WebDriverWait wait = new WebDriverWait(driver, 10, 500);

    @Step("Выбор валюты")
    public void choiceVal(String val){
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", driver.findElement(By.xpath("//h2[contains(text(),'Рассчитайте доходность')]")));
        for (WebElement element: money) {
            if(element.getText().equalsIgnoreCase(val)) {
                if(!element.isSelected()) {
                    element.click();
                    break;
                }
            }
        }
    }

    @Step("Заполнение суммы вклада")
    public void addSumDeposit(String val) {
        waitingChange(sumDeposit, val);
    }

    @Step("Выбор срока вклада")
    public void choicePeriod(String value) {
        driver.findElement(By.xpath("//div[@id='period-styler']//..")).click();
        for (WebElement webElement : list) {
            if (webElement.getAttribute("textContent").equalsIgnoreCase(value)) {
                wait.until(ExpectedConditions.elementToBeClickable(webElement)).click();
                break;
            }
        }
    }

    @Step("Ежемесячное пополнение")
    public void addSumToMounth(String value) {
        waitingChange(addPriceToMounth, value);
    }

    @Step("Выбор чекбокса \"Ежемесячная капитализация\"")
    public void setCheckBoxCapitilize() {
        String oldValue = percent.getAttribute("textContent");
        Function<? super WebDriver, Object> valueChanged = (ExpectedCondition<Object>) webDriver -> {
            String newValue = percent.getAttribute("textContent");
            return !newValue.replace(" ", "").equals(oldValue);
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
        checkBoxCapitilize.click();
        wait.until(valueChanged);
    }

    @Step("Выбор чекбокса \"Частичное снятие\"")
    public void setCheckBoxTakeMyMoney(){
        String oldValue = percent.getAttribute("textContent");
        Function<? super WebDriver, Object> valueChanged = (ExpectedCondition<Object>) webDriver -> {
            String newValue = percent.getAttribute("textContent");
            return !newValue.replace(" ", "").equals(oldValue);
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
        checkBoxTakeMyMoney.click();
        wait.until(valueChanged);
    }

    public void waitingChange(WebElement element, String text) {

        Function<? super WebDriver, Object> valueChanged = (ExpectedCondition<Object>) webDriver -> {
            String newValue = element.getAttribute("value");
            return newValue.replace(" ", "").equals(text);
        };
        //действие для изменения значения
        WebDriverWait wait = new WebDriverWait(driver, 10, 1000);
        fillsArea(element, text);
        wait.until(valueChanged);
    }

    public void fillsArea(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    @Step("Проверка ставки")
    public void assPercent(String value) {
        Assert.assertEquals(value, percent.getText());
    }

    @Step("Проверка суммы вклада по истечению срока")
    public void assTotalMoney(String value) {
        Assert.assertEquals(value, totalMoney.getText());
    }

    @Step("Проверка суммы пополнения счета по окончанию срока вклада")
    public void assMoneyFor6Mounth(String value) {
        Assert.assertEquals(value, moneyFor6Mounth.getText());
    }

    @Step("Проверка начисления денежных средств по истечению срока")
    public void assMoneyProcentel(String value) {
        Assert.assertEquals(value, moneyProcentel.getText());
    }
}
