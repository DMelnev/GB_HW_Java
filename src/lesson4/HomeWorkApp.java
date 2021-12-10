package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    public static char[][] map;
    public static final int SIZE = 5; // map size
    public static final int SET = 3;  // game set for win

    public static final char DOT_EMPTY = '•';
    public static final char DOT_HUMAN = 'X';
    public static final char DOT_AI = 'O';

    private static Scanner input = new Scanner(System.in);
    private static Random rnd = new Random();

    public static void main(String[] args) {
        initMap();
        while (true) {
            printMap();
            humanMove();
            if (checkVin(DOT_HUMAN)) {
                printMap();
                System.out.println("Вы победили!");
                break;
            }
            aiMove();
            if (checkVin(DOT_AI)) {
                printMap();
                System.out.println("Вы проиграли!");
                break;
            }
            if (checkDrawn()){
                printMap();
                System.out.println("Ничья!");
                break;
            }
        }
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (char[] line : map) Arrays.fill(line, DOT_EMPTY);
    }

    public static void printMap() {
        for (int i = 0; i < SIZE + 1; i++) System.out.print(i + "  ");
        System.out.println();
        int i = 1;
        for (char[] line : map) {
            System.out.print(i + "  ");
            for (char point : line) System.out.print(point + "  ");
            System.out.println();
            i++;
        }
    }

    public static void humanMove() {
        int x, y;
        do {
            System.out.println("Введите координаты (X, Y):");
            x = input.nextInt() - 1;
            y = input.nextInt() - 1;
            if (checkInput(x, y)) System.out.println("Ход не засчитан.");
        } while (checkInput(x, y));
        map[x][y] = DOT_HUMAN;
    }

    private static void aiMove() {
        int a, b;
        do {
            a = rnd.nextInt(SIZE);
            b = rnd.nextInt(SIZE);
        } while (checkInput(a, b));
        map[a][b] = DOT_AI;
    }

    private static boolean checkInput(int x, int y) {
        return x < 0 || x >= SIZE || y < 0 || y >= SIZE || map[x][y] != DOT_EMPTY;
    }

    private static boolean checkVin(char point) {
        int size = SIZE - SET;
        for (int i = 0; i <= size; i++) {
            for (int j = 0; j <= size; j++) {
                // matrix
                int countY = 0, countX = 0, countA = 0, countB = 0;
                for (int x = i; x < i + SET; x++) {
                    countY = 0; countX = 0;
                    for (int y = j; y < j + SET; y++) {
                        if (map[x][y] == point) countY++;   //horizontal
                        if (map[y][x] == point) countX++;   //vertical
                        if (x == y)
                            if (map[x][y] == point) countA++;   // main diagonal
                        if (x == SET - y - 1)
                            if (map[x][y] == point) countB++;   // second diagonal
                        if (countA >= SET) System.out.println("A win");
                        if (countB >= SET) System.out.println("B win");
                        if (countX >= SET) System.out.println("X win");
                        if (countY >= SET) System.out.println("Y win");
                        if (countA >= SET || countB >= SET || countX >= SET || countY >= SET) return true;
                    }
                }
            }
        }
        return false;
    }
    private static boolean checkDrawn(){
        for (char[] x : map){
            for (char point : x){
                if (point == DOT_EMPTY) return false;
            }
        }
        return true;
    }

}
