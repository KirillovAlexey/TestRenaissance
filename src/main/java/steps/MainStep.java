package steps;

import Pages.MainPage;
import io.qameta.allure.Step;

public class MainStep {
    @Step("Открыть вклад")
    public void openDeposit(){
        new MainPage().openDepositPage();
    }
}
