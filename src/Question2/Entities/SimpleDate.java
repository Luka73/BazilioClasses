package Question2.Entities;

public class SimpleDate {
    private int day;
    private int month;
    private int year;

    public SimpleDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String toString() {
        return this.day + "." + this.month + "." + this.year;
    }

    public boolean before(SimpleDate compared) {
        // first compare years
        if (this.year < compared.year) {
            return true;
        }

        // if the years are the same, compare months
        if (this.year == compared.year && this.month < compared.month) {
            return true;
        }

        // the years and the months are the same, compare days
        if (this.year == compared.year && this.month == compared.month &&
                this.day < compared.day) {
            return true;
        }

        return false;
    }

    public void advance() {
        if(day == 30) {
            if(month == 12) {
                year++;
                month = 1;
            } else {
                month++;
                day = 1;
            }
        }  else {
            day++;
        }
    }

    public void advance(int days) {
        for(int i = 1; i <= days; i++) {
            advance();
        }
    }

    public SimpleDate afterNumberOfDays (int days) {
        SimpleDate sd = new SimpleDate(day, month, year);
        sd.advance(days);
        return sd;
    }
}
