package steps;

import Pages.BasePage;
import Pages.MainPage;
import io.cucumber.java.ru.Когда;

public class ScenarioStep {
    //MainPage mainPage = new MainPage();
    MainStep mainStep = new MainStep();
    //BasePage basePage = new BasePage();
    //BaseStep baseStep = new BaseStep();

    @Когда("Нажать на открытие вклада")
    public void pushToDeposit(){
        mainStep.openDeposit();
    }
}
