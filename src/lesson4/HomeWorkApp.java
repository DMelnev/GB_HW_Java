package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int SET = 3;

    public static char DOT_EMPTY = '•';
    public static char DOT_HUMAN = 'X';
    public static char DOT_AI = 'O';

    private static Scanner input = new Scanner(System.in);
    private static Random rnd = new Random();

    public static void main(String[] args) {
        initMap();
        while (true) {
            printMap();
            humanMove();
            aiMove();
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

}
