package lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {

        //exercise one
        //prepare:
        Random rnd = new Random();
        int[] arrayInt = new int[10];
        for (int i = 0; i < arrayInt.length; i++) arrayInt[i] = rnd.nextInt(2);
        System.out.println("exercise 1:");
        System.out.println(Arrays.toString(arrayInt));
        // solution:
        for (int i = 0; i < arrayInt.length; i++) arrayInt[i] ^= 1;
        System.out.println(Arrays.toString(arrayInt));

        //exercise two
        int[] arrayInt_2 = new int[100];
        for (int i = 0; i < arrayInt_2.length; i++) arrayInt_2[i] = i + 1;
        System.out.println("exercise 2:");
        System.out.println(Arrays.toString(arrayInt_2));

        //exercise three
        int[] arrayInt_3 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrayInt_3.length; i++) {
            arrayInt_3[i] = (arrayInt_3[i] < 6) ? arrayInt_3[i] * 2 : arrayInt_3[i];
        }
        System.out.println("exercise 3:");
        System.out.println(Arrays.toString(arrayInt_3));

        //exercise four:
        int[][] arrayInt_4 = new int[5][5];
        for (int i = 0; i < arrayInt_4.length; i++) {
            for (int j = 0; j < arrayInt_4[0].length; j++) {
                arrayInt_4[i][j] = (i == j || i == arrayInt_4[0].length - j - 1) ? 1 : 0;
            }
        }
        System.out.println("exercise 4:");
        for (int[] ints : arrayInt_4) System.out.println(Arrays.toString(ints)); // чесслово это не я)) оно само )
        //for (int i=0; i < arrayInt_4.length;i++) System.out.println(Arrays.toString(arrayInt_4[i])); // это моё

        //exercise five:
        System.out.println("exercise 5:");
        System.out.println(Arrays.toString(createAndFillArray(7, 71)));

        //exercise six
        int[] arrayInt_6 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int maxValue = arrayInt_6[0], minValue = maxValue;
        for (int i = 1; i < arrayInt_6.length; i++) {
            maxValue = Math.max(arrayInt_6[i], maxValue);
            minValue = Math.min(arrayInt_6[i], minValue);
        }
        System.out.println("exercise 6:");
        System.out.printf("min value is %d, max value is %d\n", minValue, maxValue);

        //exercise seven:
        //int[] arrayInt_7 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[] arrayInt_7 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 7};
        //int[] arrayInt_7 = new int[]{1, 5, 6};
        System.out.println("exercise 7:");
        System.out.println(Arrays.toString(arrayInt_7));
        System.out.printf("Left part has %ssame right part\n", (findTits(arrayInt_7)) ? "" : "not ");

    }


    public static int[] createAndFillArray(int len, int initialValue) {         //fifth exercise
        len = Math.max(len, 0);
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    public static boolean findTits(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int sumLeft = 0, sumRight = 0;
            for (int j = 0; j < i; j++) sumLeft += array[j];
            for (int j = i; j < array.length; j++) sumRight += array[j];
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

}
