import Entities.CheckingAccount;
import Entities.SavingAccount;
import Utils.Menu;

public class Program {
    public static void main(String[] args) {
        String optionAccount = "";
        boolean loop = true;

        SavingAccount savingAccount = new SavingAccount(100, 0.5);
        CheckingAccount checkingAccount = new CheckingAccount(0, 0.2);

        while (true) {
            String optionBankMenu = Menu.getBankMenuOption();
            if (optionBankMenu.equalsIgnoreCase("C")) {
                System.out.println("Thank you! Have a nice day!");
                break;
            } else { loop = true; }
            while (loop) {
                if (optionBankMenu.equalsIgnoreCase("A")) {
                    System.out.println("*******************");
                    System.out.println("Saving Menu");
                    optionAccount = Menu.getAccountOption();
                    loop = Menu.accountMenu(optionAccount, savingAccount);
                } else if (optionBankMenu.equalsIgnoreCase("B")) {
                    System.out.println("*******************");
                    System.out.println("Checking Menu");
                    optionAccount = Menu.getAccountOption();
                    loop = Menu.accountMenu(optionAccount, checkingAccount);
                } else {
                    System.out.println("Invalid option");
                }
            }
        }
    }
}
