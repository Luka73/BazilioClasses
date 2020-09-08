package Question3.Entities;

public class Money {
    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    public String toString() {
        String zero = "";
        if (cents < 10) { //errado (cents <= 10)
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }

    public Money plus(Money addition) {
        double euros = this.euros + addition.euros;
        int cents = this.cents + addition.cents;
        euros = euros + (cents / 100.0);

        int intPart = (int) euros;
        int decimalPart = (int) ((euros - intPart) * 100);
        //System.out.println("Integer Part: " + intPart);
        //System.out.println("Decimal Part: " + decimalPart);
        return new Money(intPart, decimalPart);
    }

    public boolean lessThan(Money compared) {
        double myMoney = euros + (cents / 100.0);
        double comparedMoney = compared.euros + (compared.cents / 100.0);

        return myMoney < comparedMoney;
    }

    public Money minus(Money decreaser) {
        double euros = this.euros - decreaser.euros;
        int cents = Math.max(this.cents, decreaser.cents) - Math.min(this.cents, decreaser.cents);
        euros = euros - (cents / 100.0);

        if(euros < 0) {
            euros = 0;
        }

        int intPart = (int) euros;
        int decimalPart = (int) ((euros - intPart) * 100);

        return new Money(intPart, decimalPart);
    }
}
