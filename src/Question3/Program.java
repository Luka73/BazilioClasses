package Question3;

import Question3.Entities.Money;

public class Program {
    public static void main(String[] args) {

        Money a1 = new Money(10,0);
        Money b1 = new Money(5,0);

        Money c1 = a1.plus(b1);

        System.out.println(a1);  // 10.00e
        System.out.println(b1);  // 5.00e
        System.out.println(c1);  // 15.00e

        a1 = a1.plus(c1);          // NB: a new Money object is created, and is placed "at the end of the strand connected to a"
//  the old 10 euros at the end of the strand disappears and the Java garbage collector takes care of it

        System.out.println(a1);  // 25.00e
        System.out.println(b1);  // 5.00e
        System.out.println(c1);  // 15.00e


        Money a2 = new Money(10, 0);
        Money b2 = new Money(3, 0);
        Money c2 = new Money(5, 0);

        System.out.println(a2.lessThan(b2));  // false
        System.out.println(b2.lessThan(c2));  // true


        Money a3 = new Money(10, 0);
        Money b3 = new Money(3, 50);

        Money c3 = a3.minus(b3);

        System.out.println(a3);  // 10.00e
        System.out.println(b3);  // 3.50e
        System.out.println(c3);  // 6.50e

        c3 = c3.minus(a3);       // NB: a new Money object is created, and is placed "at the end of the strand connected to c"
//  the old 6.5 euros at the end of the strand disappears and the Java garbage collector takes care of it

        System.out.println(a3);  // 10.00e
        System.out.println(b3);  // 3.50e
        System.out.println(c3);  // 0.00e
    }
}
