import Entities.CheckingAccount;
import Entities.SavingAccount;
import Utils.Menu;

public class Program {
    public static void main(String[] args) {
        String optionAccount = "";
        SavingAccount savingAccount = new SavingAccount(100, 2);
        CheckingAccount checkingAccount = new CheckingAccount(20, 5);

        while (true) {
            String optionBankMenu = Menu.getBankMenuOption();
            if (optionBankMenu.equalsIgnoreCase("C")) {
                System.out.println("Thank you! Have a nice day!");
                break;
            }
            while (!optionAccount.equalsIgnoreCase("D")) {
                if (optionBankMenu.equalsIgnoreCase("A")) {
                    System.out.println("*******************");
                    System.out.println("Saving Menu");
                    optionAccount = Menu.getAccountOption();
                    Menu.accountMenu(optionAccount, savingAccount);
                } else if (optionBankMenu.equalsIgnoreCase("B")) {
                    System.out.println("*******************");
                    System.out.println("Checking Menu");
                    optionAccount = Menu.getAccountOption();
                    Menu.accountMenu(optionAccount, checkingAccount);
                } else {
                    System.out.println("Invalid option");
                }
            }
        }
    }
}
