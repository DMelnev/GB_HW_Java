package lesson4;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    static char[][] map;
    static final int SIZE = 10; // размер поля, минимум 3 и равно или более SET (в программе нет проверки на это) и не более 99
    static final int SET = 5;  // длина победной линии минимум 3 (в программе нет проверки на это)
    static final char DOT_EMPTY = '•';
    static final char DOT_HUMAN = 'X';
    static final char DOT_AI = 'O';

    static Scanner input = new Scanner(System.in);
    static Random rnd = new Random();
    static int aiX, aiY;

    public static void main(String[] args) {
        initMap();
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
//        for (int i = 0; i < SIZE; i++) {
//            for (int j = 0; j < SIZE; j++) map[i][j] = DOT_EMPTY; //заполняем массив
//        }
        for (char[] line : map) Arrays.fill(line, DOT_EMPTY);//заполняем массив
    }

    static void printMap() {
        System.out.print("   ");//выводим три пробела для выравнивания верхней строки.
        for (int i = 1; i < SIZE + 1; i++) {
            System.out.printf("%d %s", i, (i < 10) ? " " : "");  //выводим верхнюю строку
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.printf("%d%s ", (i + 1), (i < 9) ? " " : "");
//            System.out.print((i + 1) + "  "); // выводим начало строки
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
        do {
            aiX = rnd.nextInt(SIZE);
            aiY = rnd.nextInt(SIZE);
        } while (checkInput(aiX, aiY));
        blockHuman();
        map[aiX][aiY] = DOT_AI;
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
        for (char[] line : map)
            for (char point : line)
                if (point == DOT_EMPTY) return false;
        return true; // ничего не нашли, ничья.
    }

    static void blockHuman() {
        for (int frame = SET - 1; frame > 1; frame--) { //пеебираем размеры фреймов
            for (int i = 0; i <= SIZE - frame; i++) { //строка карты
                for (int j = 0; j <= SIZE - frame; j++) { // столбец карты
                    // перебираем внутри фрейма
                    int countA = 0, countB = 0; //инициализация счетчиков по диагоналям
                    for (int x = 0; x < frame; x++) { //столбец фрейма
                        int countY = 0, countX = 0; //инициализация счетчиков по строкам
                        for (int y = 0; y < frame; y++) { //строка фрейма
                            if (map[x + i][y + j] == DOT_HUMAN) countY++;               //проверяем горизонтали
                            if (map[y + j][x + i] == DOT_HUMAN) countX++;               //проверяем вертикали
                            if (x == y) {                                           //если диагональ
                                if (map[x + i][y + j] == DOT_HUMAN)
                                    countA++;           //проверяем главную диагональ фрейма
                                if (map[x + i][frame - y - 1 + j] == DOT_HUMAN) countB++; //проверяем доп. диагональ
                            }
                            if (countA >= frame) {
                                if (checkFrame(i + x, j + y, frame, 'A')) return;
                            }
                            if (countB >= frame) {
                                if (checkFrame(i + x, j + y, frame, 'B')) return;
                            }
                            if (countX >= frame) {
                                if (checkFrame(i + x, j + y, frame, 'X')) return;
                            }
                            if (countY >= frame) {
                                if (checkFrame(i + x, j + y, frame, 'Y')) return;
                            }

                        }
                    }
                }
            }
        }
    }

    static boolean checkFrame(int xFrame, int yFrame, int frame, char type) {
//        System.out.println("type = " + type);
//        System.out.println("frame = " + frame);
//        System.out.println("x = " + xFrame);
//        System.out.println("y = " + yFrame);
//        System.out.println();
        switch (type) {
            case ('X'): // вертикальная линия
                if ((yFrame < SIZE - 1) && (map[yFrame + 1][xFrame] == DOT_EMPTY)) { // под линией
                    aiX = yFrame + 1;
                    aiY = xFrame;
                    System.out.println("set X down");
                    return true;
                }
                if ((yFrame - frame >= 0) && (map[yFrame - frame][xFrame] == DOT_EMPTY)) { // над линией
                    aiX = yFrame - frame;
                    aiY = xFrame;
                    System.out.println("set X up");
                    return true;
                }
                break;
            case ('Y'): // горизонтальная линия
                if ((yFrame < SIZE - 1) && (map[xFrame][yFrame + 1] == DOT_EMPTY)) { // справа от линии
                    aiX = xFrame;
                    aiY = yFrame + 1;
                    System.out.println("set Y down");
                    return true;
                }
                if ((yFrame - frame >= 0) && (map[xFrame][yFrame - frame] == DOT_EMPTY)) { // слева от линии
                    aiX = xFrame;
                    aiY = yFrame - frame;
                    System.out.println("set Y up");
                    return true;
                }
                break;
            case ('A'):
                if ((yFrame < SIZE - 1) && (xFrame < SIZE - 1) && (map[xFrame + 1][yFrame + 1] == DOT_EMPTY)) { // справа от диагонали
                    aiX = xFrame + 1;
                    aiY = yFrame + 1;
                    System.out.println("set A down");
                    return true;
                }
                if ((yFrame - frame >= 0) && (xFrame - frame >= 0) && (map[xFrame - frame][yFrame - frame] == DOT_EMPTY)) { // слева от диагонали
                    aiX = xFrame - frame;
                    aiY = yFrame - frame;
                    System.out.println("set A up");
                    return true;
                }
                break;
            case ('B'):
                System.out.println("set B");
                if ((yFrame > 0) && (xFrame < SIZE - 1) && (map[xFrame + 1][yFrame - 2] == DOT_EMPTY)) { // слева от вспом диагонали
                    aiX = xFrame + 1;
                    aiY = yFrame - 2;
                    System.out.println("set B down");
                    return true;
                }
                if ((yFrame + frame <= SIZE) && (xFrame - frame >= 0) && (map[xFrame - frame][yFrame + frame - 1] == DOT_EMPTY)) { // справа от вспом диагонали
                    aiX = xFrame - frame;
                    aiY = yFrame + frame - 1;
                    System.out.println("set B up");
                    return true;
                }
                break;
            default:
                // что то должны сделать... пока не придумал ))
                break;
        }
        return false;
    }

}
