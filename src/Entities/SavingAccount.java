package Entities;

public class SavingAccount extends BankingAccount {

    private final double WITHDRAWALS_CHARGE = 1;

    public SavingAccount(double startingBalance, double annualInterestRate) {
        super(startingBalance, annualInterestRate);

        accountStatus();
    }

    @Override
    public void makeWithdraw(double amount) {
        if(activeAccount)
            super.makeWithdraw(amount);

        accountStatus();
    }

    public void makeDeposit(double amount) {
        if(!activeAccount && (currentBalance + amount) > 25)
            activeAccount = true;

        if(activeAccount)
            super.makeDeposit(amount);
    }

    public void doMonthlyReport() {
        if(numberOfWithdrawals > 4)
            monthlyServiceCharge += WITHDRAWALS_CHARGE * numberOfWithdrawals;

        super.doMonthlyReport();

        accountStatus();
    }

    private void accountStatus() {
        activeAccount = !(startingBalance <= 25);
    }
}
