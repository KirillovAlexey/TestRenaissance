package steps;

import Pages.DepositPage;
import io.cucumber.java.ru.Когда;

public class DepositStep {
    DepositPage depositPage = new DepositPage();

    @Когда("^Выбор валюты: (.+)$")
    public void choiceRur(String val) {
        depositPage.choiceVal(val);
    }

    @Когда("^Заполнить сумму вклада: (.+)$")
    public void inputInfo(String val) {
        depositPage.addSumDeposit(val);
    }

    @Когда("Выбрать срок: (.+)")
    public void choiceMount(String val) {
        depositPage.choicePeriod(val);
    }

    @Когда("Указать сумму ежемесячного пополнения вклада: (.+)")
    public void addSum(String val) {
        depositPage.addSumToMounth(val);
    }

    @Когда("Выбрать ежемесячную капитализацию")
    public void checkCapital() {
        depositPage.setCheckBoxCapitilize();
    }

    @Когда("Выбрать частичное снятие")
    public void checkTmM(){
        depositPage.setCheckBoxTakeMyMoney();
    }

    @Когда("Проверка ставки: (.+)")
    public void checkPercent(String val) {
        depositPage.assPercent(val);
    }

    @Когда("Проверка суммы на вкладе по истечению срока: (.+)")
    public void checkTotal(String val) {
        depositPage.assTotalMoney(val);
    }

    @Когда("Проверка суммы пополнения за весь срок: (.+)")
    public void checkAddSum(String val) {
        depositPage.assMoneyFor6Mounth(val);
    }

    @Когда("Проверка начисленных процентов за весь срок вклада: (.+)")
    public void checkSumPercent(String val) {
        depositPage.assMoneyProcentel(val);
    }
}
