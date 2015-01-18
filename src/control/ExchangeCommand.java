package control;

import swing.CurrencyDialog;
import model.Money;
import swing.MoneyDialog;
import model.MoneyViewer;

public class ExchangeCommand extends Command{

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public ExchangeCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {
        moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));
    }

    private double getExchangeRate() {
        return 0.9;
    }

    private double calculateAmount() {
        return moneyDialog.getMoney().getAmount() * getExchangeRate();
    }

}
