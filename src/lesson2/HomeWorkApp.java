/**
 * Java 1. Homework 2
 *
 * @author Melnev Dmitry
 * @version created at 03.12.2021 corrected at 14.12.2021
 */
package lesson2;

public class HomeWorkApp {

    static boolean checkBetween10_20(int a, int b) {          // first exercise

        return ((a + b) >= 10) && ((a + b) <= 20);
    }

    static void checkPositive(int a) {                        // second exercise
        System.out.printf("Number %d is %s.\n", a,
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

    public static void main(String[] args) {

        //checking result of exercise one
        int[][] nmbr = {{15, 6}, {-2, 4}, {0, 10}};
        for (int[] pnt : nmbr) {
            System.out.printf("%d is %s 10 and 20\n", (pnt[0] + pnt[1]),
                    (checkBetween10_20(pnt[0], pnt[1]) ? "between" : "beyond"));
            //checking result of exercise two
            checkPositive(pnt[0]);
            //checking result of exercise three
            System.out.printf("Number %d is %s.\n", pnt[0],
                    (checkNegative(pnt[0])) ? "negative" : "positive");
        }

        //checking result of exercise four
        int someNumber1 = 3;
        String str = "Some String";
        writeString(str, someNumber1);

        //checking result of exercise five
        int[] tableYear = {2000, 2001, 2100, 2104};
        for (int year : tableYear)
            System.out.printf("%d is%s a leap year.\n", year, (isYearLeap(year)) ? "" : "n't");
    }

}

