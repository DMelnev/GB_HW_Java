package lesson4;

import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    static char[][] map;
    static final int SIZE = 5; // размер поля, минимум 3 и равно или более SET (в программе нет проверки на это)
    static final int SET = 3;  // длина победной линии минимум 3 (в программе нет проверки на это)
    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static final Scanner input = new Scanner(System.in); // IDEA подсказала, что нужно сделать final
    static final Random rnd = new Random();// IDEA подсказала, что нужно сделать final

    public static void main(String[] args) {
        initMap();
//        printMap();
        while (true) {
            printMap();
            humanMove();
            if (checkWin(DOT_HUMAN)) {
                printMap();
                System.out.println("Вы победили!");
                break;
            }
            if (checkDrawn()) {
                printMap();
                System.out.println("Ничья!");
                break;
            }
            aiMove();
            if (checkWin(DOT_AI)) {
                printMap();
                System.out.println("Вы проиграли!");
                break;
            }
        }
    }

    static void initMap() {
        map = new char[SIZE][SIZE]; // создаем массив поля
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) map[i][j] = DOT_EMPTY; //заполняем массив
        }
    }

    static void printMap() {
        System.out.print("   ");//выводим три пробела для выравнивания верхней строки.
        for (int i = 1; i < SIZE + 1; i++) System.out.print(i + "  ");  //выводим верхнюю строку
        System.out.println();   //перевод строки
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + "  "); // выводим начало строки
            for (int j = 0; j < SIZE; j++)
                System.out.print(map[i][j] + "  "); //выводим содержимое массива
            System.out.println(); // перевод строки
        }
    }

    static void humanMove() {
        int x, y;
        do {
            System.out.println("Введите координаты (X, Y):");
            x = input.nextInt() - 1;
            y = input.nextInt() - 1;
            if (checkInput(x, y)) System.out.println("Ход не засчитан.");
        } while (checkInput(x, y));
        map[x][y] = DOT_HUMAN;
    }

    static void aiMove() {
        int x, y;
        do {
            x = rnd.nextInt(SIZE);
            y = rnd.nextInt(SIZE);
        } while (checkInput(x, y));
        map[x][y] = DOT_AI;
    }

    static boolean checkInput(int x, int y) {
        return (x < 0) || (x >= SIZE) || (y < 0) || (y >= SIZE) || (map[x][y] != DOT_EMPTY);
    }

    static boolean checkWin(char point) {
        int border = SIZE - SET;  // граница положения фреймов
        // перебираем фреймы на всей карте
        for (int i = 0; i <= border; i++) { //столбец карты
            for (int j = 0; j <= border; j++) { //строка карты
                // перебираем внутри фрейма
                int countA = 0, countB = 0; //инициализация счетчиков по диагоналям
                for (int x = 0; x < SET; x++) { //столбец фрейма
                    int countY = 0, countX = 0; //инициализация счетчиков по строкам
                    for (int y = 0; y < SET; y++) { //строка фрейма
                        if (map[x + i][y + j] == point) countY++;               //проверяем горизонтали
                        if (map[y + j][x + i] == point) countX++;               //проверяем вертикали
                        if (x == y) {                                           //если диагональ
                            if (map[x + i][y + j] == point) countA++;           //проверяем главную диагональ фрейма
                            if (map[x + i][SET - y - 1 + j] == point) countB++; //проверяем доп. диагональ
                        }
                        if (countA >= SET || countB >= SET || countX >= SET || countY >= SET) return true;//если нашли
                    }
                }
            }
        }
        return false;
    }

    static boolean checkDrawn() {
        for (int x = 0; x < SIZE; x++) { //перебираю столбцы
            for (int y = 0; y < SIZE; y++) { //перебираю содержимое столбцов
                if (map[x][y] == DOT_EMPTY) return false; //если встретил пусто
            }
        }
        return true; // ничего не нашли, ничья.
    }

}
