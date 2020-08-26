package Entities;

public class CheckingAccount extends BankingAccount {

    private final double WITHDRAWALS_CHARGE = 15;
    private final double MONTHLY_FEE = 5;
    private final double FEE_PER_WITHDRAWAL = 0.10;

    public CheckingAccount(double startingBalance, double annualInterestRate) {
        super(startingBalance, annualInterestRate);
    }

    public void makeWithdraw(double amount) {
        if(amount > currentBalance)
            currentBalance -= WITHDRAWALS_CHARGE;
        else
            super.makeWithdraw(amount);

    }

    public void doMonthlyReport() {
        monthlyServiceCharge += MONTHLY_FEE;
        monthlyServiceCharge += (numberOfWithdrawals * FEE_PER_WITHDRAWAL);
        super.doMonthlyReport();
    }
}
