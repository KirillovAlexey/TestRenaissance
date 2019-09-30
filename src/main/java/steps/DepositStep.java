package steps;

import Pages.DepositPage;
import io.cucumber.java.ru.Когда;

public class DepositStep {
    DepositPage depositPage = new DepositPage();

    @Когда("Заполнить заявку на открытие депозита")
    public void inputInfo(){
        depositPage.insertDate();
    }
}
