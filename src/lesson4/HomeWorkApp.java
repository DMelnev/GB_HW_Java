package lesson4;

import java.util.Arrays;

public class HomeWorkApp {
    public static char[][] map;
    public static final int SIZE = 5;
    public static final int SET = 3;

    public static char DOT_EMPTY = '•';
    public static char DOT_HUMAN = 'X';
    public static char DOT_AI = 'O';

    public static void main(String[] args) {
        initMap();
        printMap();
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (char[] line : map) Arrays.fill(line, DOT_EMPTY);
    }

    public static void printMap() {
        for (char[] line : map) {
            for (char point : line) System.out.print(point + "  ");
            System.out.println();
        }
    }
}
