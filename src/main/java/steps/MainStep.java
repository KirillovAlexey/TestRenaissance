package steps;

import Pages.MainPage;
import io.cucumber.java.ru.Когда;
import io.qameta.allure.Step;

public class MainStep {
    @Когда("Нажать на открытие вклада")
    public void openDeposit(){
        new MainPage().openDepositPage();
    }
}
