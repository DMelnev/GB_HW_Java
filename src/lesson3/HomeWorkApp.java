/**
 * Java 1. Homework 3
 *
 * @author Melnev Dmitry
 * @version created at 06.12.2021 corrected at 15.12.2021
 */
package lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeWorkApp {
    static Random rnd = new Random();

    public static void main(String[] args) {

        System.out.println("exercise 1:");
        int[] arrayInt = createAndFillRandomArray(12, 2); // part one
        System.out.println(Arrays.toString(arrayInt));
        System.out.println(Arrays.toString(invertArray(arrayInt))); //part two

        System.out.println("\nexercise 2:");
        System.out.println(Arrays.toString(createLinearArray(100)));

        System.out.println("\nexercise 3:");
        int[] arrayInt_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayInt_3));
        System.out.println(Arrays.toString(modifyArray(arrayInt_3)));

        System.out.println("\nexercise 4:");
        for (int[] line : createCrossArray(7))
            System.out.println(Arrays.toString(line));

        //exercise five:
        System.out.println("\nexercise 5:");
        System.out.println(Arrays.toString(createAndFillArray(7, 71)));

        System.out.println("\nexercise 6:");
        int[] arrayInt_6 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println(Arrays.toString(arrayInt_6));
        System.out.printf("min value is %d, max value is %d\n", getMinElement(arrayInt_6), getMaxElement(arrayInt_6));

        System.out.println("\nexercise 7:");
        int[][] arrayInt_7 = {{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}, //false
                {1, 5, 3, 2, 11, 4, 5, 2, 4, 7},//true
                {1, 5, 6},//true
                {12, 1, 4, 56, 123, 23, -4, 12, 65, 76, 34, 13, 23}}; // true
        for (int[] tempArray : arrayInt_7) {
            System.out.println(Arrays.toString(tempArray));
            System.out.printf("Left part has %ssame right part\n\n", (findSameParts(tempArray)) ? "" : "not ");
        }

        System.out.println("exercise 8:");
        int[] arrayInt_8 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] shifts = {0, 1, 3, 13, 10, -1, -3, -5, -15};// - left, + right

        for (int i : shifts) {
            System.out.print("shift = " + i + " - ");
            System.out.println(Arrays.toString(arrayShift(arrayInt_8.clone(), i)));
            //передаю в метод копию массива, а не указатель, что бы не изменить оригинал
        }
    }

    static int[] createAndFillRandomArray(int len, int bound) {          //first exercise part one
        int[] arrayInt = new int[len];
        for (int i = 0; i < arrayInt.length; i++)
            arrayInt[i] = rnd.nextInt(bound);
        return arrayInt;
    }

    static int[] invertArray(int[] array) {                             // first exercise part two
        for (int i = 0; i < array.length; i++)
            array[i] ^= 1;
        return array;
    }

    static int[] createLinearArray(int len) {                           // second exercise
        int[] array = new int[len];
        for (int i = 0; i < array.length; i++)
            array[i] = i + 1;
        return array;
    }

    static int[] modifyArray(int[] array) {                              // third exercise
        for (int i = 0; i < array.length; i++)
            array[i] *= (array[i] < 6) ? 2 : 1;
        return array;
    }

    static int[][] createCrossArray(int size) {                         //fourth exercise
        int[][] array = new int[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = (i == j || i == array[0].length - j - 1) ? 1 : 0;
            }
        }
        return array;
    }

    static int[] createAndFillArray(int len, int initialValue) {         //fifth exercise
        int[] array = new int[len];
//        for (int i = 0; i < len; i++) array[i] = initialValue; // то же самое, что и ниже
        Arrays.fill(array, initialValue);
        return array;
    }

    static int getMaxElement(int[] array) {                             //sixth exercise part one
        int maxValue = array[0];
        for (int temp : array) {
//            maxValue = (temp > maxValue) ? temp : maxValue;
            maxValue = Math.max(temp, maxValue);
        }
        return maxValue;
    }

    static int getMinElement(int[] array) {                             //*sixth exercise part two
        int minValue = array[0];
        for (int temp : array) {
//            minValue = (temp < minValue) ? temp : minValue;
            minValue = Math.min(temp, minValue);
        }
        return minValue;
    }

    static boolean findSameParts(int[] array) {                          //**seventh exercise
        for (int i = 1; i < array.length; i++) {
            int sumLeft = 0, sumRight = 0;
            for (int j = 0; j < i; j++) sumLeft += array[j];
            for (int j = i; j < array.length; j++) sumRight += array[j];
            if (sumLeft == sumRight) return true;
        }
        return false;
    }

    static int[] arrayShift(int[] array, int shift) {                    // ***eighth exercise
        shift %= array.length;                                                          // убираем все лишнее
        shift += (shift < 0) ? array.length : 0;                                        // корректируем отрицательное направление
        while (shift > 0) {                                                             // запускаем shift сдвигов
            int lastElement = array[array.length - 1];                                  // сохраняем последний элемент
            for (int i = array.length - 2; i >= 0; i--) array[i + 1] = array[i];        // сдвигаем массив на 1 вправо
//            System.arraycopy(array, 0, array, 1, array.length - 1);                   // то же самое что выше
            array[0] = lastElement;                                                    // восстанавливаем первый элемент
            shift--;
        }
        return array;
    }

}