package lesson4;

import java.sql.Array;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    static char[][] map;
    static final int SIZE = 5; // размер поля, минимум 3 и равно или более SET (в программе нет проверки на это)
    static final int SET = 4;  // длина победной линии минимум 3 (в программе нет проверки на это)
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
        for (int i = 1; i < SIZE + 1; i++) System.out.print(i + "  ");  //выводим верхнюю строку
        System.out.println();
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
        do {
            aiX = rnd.nextInt(SIZE);
            aiY = rnd.nextInt(SIZE);
        } while (checkInput(aiX, aiY));
        blockUser();
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

    static void blockUser() {
        for (int frame = SET - 1; frame > 0; frame--) { //пеебираем размеры фреймов
            for (int i = 0; i <= SIZE - frame; i++) { //строка карты
                for (int j = 0; j <= SIZE - frame; j++) { // столбец карты
                    // перебираем внутри фрейма
                    int countA = 0, countB = 0; //инициализация счетчиков по диагоналям
                    for (int x = 0; x < frame; x++) { //столбец фрейма
                        int countY = 0, countX = 0; //инициализация счетчиков по строкам
                        for (int y = 0; y < frame; y++) { //строка фрейма
                            if (map[x + i][y + j] == DOT_AI) countY++;               //проверяем горизонтали
                            if (map[y + j][x + i] == DOT_AI) countX++;               //проверяем вертикали
                            if (x == y) {                                           //если диагональ
                                if (map[x + i][y + j] == DOT_AI) countA++;           //проверяем главную диагональ фрейма
                                if (map[x + i][frame - y - 1 + j] == DOT_AI) countB++; //проверяем доп. диагональ
                            }
                            if (countA >= frame){

                            }
                            if (countB >= frame){

                            }
                            if (countX >= frame){
                                if (checkFrame(i,j,frame,'X')) return;
                            }
                            if (countY >= frame){

                            }

                        }
                    }
                }
            }
        }
    }
    static boolean checkFrame(int xFrame, int yFrame, int frame, char type){
        switch (type){
            case ('X'):
                System.out.println("type = " + type);
                System.out.println("frame = " + frame);
                System.out.println("x = " + xFrame);
                System.out.println("y = " + yFrame);
                System.out.println();


                break;
            case ('Y'):
                break;
            case ('A'):
                break;
            case ('B'):
                break;
            default:
                break;
        }
        return false;
    }

}
