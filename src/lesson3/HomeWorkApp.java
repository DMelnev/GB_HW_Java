package lesson3;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {

        //exercise one
        //prepare:
        Random rnd = new Random();
        int[] arrayInt = new int[10];
        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = rnd.nextInt(2);
        }
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
            arrayInt_3[i] *= (arrayInt_3[i] < 6) ? 2 : 1;
        }
        System.out.println("exercise 3:");
        System.out.println(Arrays.toString(arrayInt_3));

        //exercise four:
        int[][] arrayInt_4 = new int[10][10];
        for (int i = 0; i < arrayInt_4.length; i++) {
            for (int j = 0; j < arrayInt_4[0].length; j++) {
                arrayInt_4[i][j] = (i == j || i == arrayInt_4[0].length - j - 1) ? 1 : 0;
            }
        }
        System.out.println("exercise 4:");
        for (int[] ints : arrayInt_4) System.out.println(Arrays.toString(ints));

        //exercise five:
        System.out.println("exercise 5:");
        System.out.println(Arrays.toString(createAndFillArray(7, 71)));

        //exercise six
        int[] arrayInt_6 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int maxValue = arrayInt_6[0], minValue = arrayInt_6[0];
        for (int j : arrayInt_6) {
            maxValue = Math.max(j, maxValue);
            minValue = Math.min(j, minValue);
        }
        System.out.println("exercise 6:");
        System.out.printf("min value is %d, max value is %d\n", minValue, maxValue);

        //exercise seven:
        //int[] arrayInt_7 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; // false
        int[] arrayInt_7 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 7}; // true
        //int[] arrayInt_7 = new int[]{1, 5, 6}; // true
        System.out.println("exercise 7:");
        System.out.println(Arrays.toString(arrayInt_7));
//        System.out.printf("Left part has %ssame right part\n", (findSameParts(arrayInt_7)) ? "" : "not ");
        System.out.print("Left part has ");                         // не усложняем (((
        if (!findSameParts(arrayInt_7)) System.out.print("not ");
        System.out.println("same right part");

        //exercise eight
        int[] arrayInt_8 = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 7};
        int shifting = 12; // - left, + right
        System.out.println("exercise 8:");
        System.out.println(Arrays.toString(arrayInt_8));
        System.out.println(Arrays.toString(arrayShift(arrayInt_8, shifting)));
    }


    public static int[] createAndFillArray(int len, int initialValue) {         //fifth exercise
        len = Math.max(len, 0);
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    public static boolean findSameParts(int[] array) {                               //seventh exercise
        for (int i = 1; i < array.length; i++) {
            int sumLeft = 0, sumRight = 0;
            for (int j = 0; j < i; j++) sumLeft += array[j];
            for (int j = i; j < array.length; j++) sumRight += array[j];
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    public static int[] arrayShift(int[] array, int shift) {                    // eighth exercise
        shift %= array.length;                                                          // убираем все лишнее
        shift += (shift < 0) ? array.length : 0;                                        // выбираем направление
        while (shift > 0) {                                                             // запускаем shift сдвигов
            int lastElement = array[array.length - 1];                                  // сохраняем последний элемент
            System.arraycopy(array, 0, array, 1, array.length - 1); // сдвигаем на 1
            array[0] = lastElement;                                                    // восстанавливаем первый элемент
            shift--;
        }
        return array;
    }

}
