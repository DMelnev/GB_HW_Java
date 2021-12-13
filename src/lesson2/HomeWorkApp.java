package lesson2;

public class HomeWorkApp {

    public static boolean checkBetween10_20(int a, int b) {          // first exercise

        return ((a + b) >= 10) && ((a + b) <= 20);
    }

    static void checkPositive(int a) {                        // second exercise
        System.out.printf("Number %s is %s.\n", a,
                (a < 0) ? "negative" : "positive");
    }

    static boolean checkNegative(int a) {                      // third exercise
        return a < 0;
    }

    static void writeString(String str, int a) {               // fourth exercise
        for (int i = 0; i < a; i++) {
            System.out.println(str);
        }
    }

    static boolean isYearLeap(int year) {                       // fifth exercise
        return (year % 4 == 0) && ((year % 100 > 0) || (year % 400 == 0));
    }

    static void main(String[] args) {

        //checking result of exercise one
        int someNumber1 = 15, someNumber2 = 6;
        System.out.printf("%s is %s 10 and 20\n", (someNumber1 + someNumber2),
                (checkBetween10_20(someNumber1, someNumber2)) ? "between" : "beyond");

        //checking result of exercise two
        someNumber1 = 5;
        checkPositive(someNumber1);

        //checking result of exercise three
        someNumber1 = -5;
        System.out.printf("Number %s is %s.\n", someNumber1,
              (checkNegative(someNumber1)) ? "negative" : "positive");

        //checking result of exercise four
        someNumber1 = 3;
        String str = "Some String";
        writeString(str, someNumber1);

        //checking result of exercise five
        int year = 2401;
        System.out.printf("%s%s leap year.\n", year, (isYearLeap(year)) ? "" : " isn't a");
    }

}

