/**
 * @author Melnev Dmitry
 * @version 2021-12-18
 */
package lesson4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class HomeWorkApp {
    char[][] map;
    int size; //настраиваемый размер поля
    int set;  //настраиваемый  длина победной линии
    final char DOT_EMPTY = '•';
    final char DOT_HUMAN = 'X';
    final char DOT_AI = 'O';

    Scanner input;
    Random rnd;
    int aiX, aiY;

    HomeWorkApp() {
        input = new Scanner(System.in);
        rnd = new Random();
    }

    public static void main(String[] args) {
        new HomeWorkApp().game();
    }

    void game() {
        enterMapSize();
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
            moveAI();
            if (checkWin(DOT_AI)) {
                printMap();
                System.out.println("Вы проиграли!");
                break;
            }
            if (checkDrawn()) {
                printMap();
                System.out.println("Ничья!");
                break;
            }
        }
    }

    void enterMapSize() {
        do {
            System.out.println("Введите размер поля (от 3 до 99)");
            size = input.nextInt();
        } while ((size < 3) || (size > 99));
        do {
            System.out.println("Введите количество победных точек (от 3 до " + size + ")");
            set = input.nextInt();
        } while ((set < 3) || (set > size));
        map = new char[size][size];
    }

    void initMap() {
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) map[i][j] = DOT_EMPTY; //заполняем массив
//        }
        for (char[] line : map) Arrays.fill(line, DOT_EMPTY);//заполняем массив
    }

    void printMap() {
        System.out.print("   ");//выводим три пробела для выравнивания верхней строки.
        for (int i = 1; i < size + 1; i++) {
            System.out.printf("%d %s", i, (i < 10) ? " " : "");  //выводим верхнюю строку
        }
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.printf("%d%s ", (i + 1), (i < 9) ? " " : "");// выводим начало строки
            for (int j = 0; j < size; j++)
                System.out.print(map[i][j] + "  "); //выводим содержимое массива
            System.out.println();
        }
    }

    void humanMove() {
        int x, y;
        do {
            System.out.print("Введите координаты (X, Y):"); //к сожалению я попутал x и y потому тут не совсем как нужно ((
            //так как сначала начал писать, а потом посмотрел видео и поправил
            y = input.nextInt() - 1;
            x = input.nextInt() - 1;
            if (checkInput(x, y)) System.out.println("Ход не засчитан.");
        } while (checkInput(x, y));
        map[x][y] = DOT_HUMAN;
    }

    void moveAI() {
        do {
            aiX = rnd.nextInt(size);
            aiY = rnd.nextInt(size);
        } while (checkInput(aiX, aiY));
        blockHuman();
        map[aiX][aiY] = DOT_AI;
    }

    boolean checkInput(int x, int y) {
        return (x < 0) || (x >= size) || (y < 0) || (y >= size) || (map[x][y] != DOT_EMPTY);
    }

    boolean checkWinAndBlock(char point, int frame, boolean isWin) {
        int border = size - frame;  // граница положения фреймов
        // перебираем фреймы на всей карте
        for (int i = 0; i <= border; i++) { //столбец карты
            for (int j = 0; j <= border; j++) { //строка карты
                // перебираем внутри фрейма
                int countA = 0, countB = 0; //инициализация счетчиков по диагоналям
                for (int x = 0; x < frame; x++) { //столбец фрейма
                    int countY = 0, countX = 0; //инициализация счетчиков по строкам
                    for (int y = 0; y < frame; y++) { //строка фрейма
                        if (map[x + i][y + j] == point) countY++;               //проверяем горизонтали
                        if (map[y + j][x + i] == point) countX++;               //проверяем вертикали
                        if (x == y) {                                           //если диагональ
                            if (map[x + i][y + j] == point) countA++;           //проверяем главную диагональ фрейма
                            if (map[x + i][frame - y - 1 + j] == point) countB++; //проверяем доп. диагональ
                        }
                        if (isWin) {    // если проверяем на победу

                            if (countA >= set || countB >= set || countX >= set || countY >= set)
                                return true;//если нашли

                        } else {     // если проверяем на блокировку

                            if (x == y) {
                                if ((countA >= frame) &&
                                        (checkFrame(i + x, j + y, frame, 'A'))) return true;
                                if ((countB >= frame) &&
                                        (checkFrame(i + x, frame - y - 1 + j, frame, 'B'))) return true;
                            }
                            if ((countX >= frame) &&
                                    (checkFrame(i + x, j + y, frame, 'X'))) return true;
                            if ((countY >= frame) &&
                                    (checkFrame(i + x, j + y, frame, 'Y'))) return true;
                            if (x == y) {
                                if ((frame > 2) && (countA == frame - 1) &&
                                        (checkFrame(i + x, j + y, frame, 'E'))) return true;
                                if ((frame > 2) && (countB == frame - 1) &&
                                        (checkFrame(i + x, frame - y - 1 + j, frame, 'F'))) return true;
                            }
                            if ((frame > 2) && (countX == frame - 1) &&
                                    (checkFrame(i + x, j + y, frame, 'C'))) return true;
                            if ((frame > 2) && (countY == frame - 1) &&
                                    (checkFrame(i + x, j + y, frame, 'D'))) return true;

                        }
                    }
                }
            }
        }
        return false;
    }

    boolean checkWin(char point) { // перегружаем со значением по умолчанию

        return checkWinAndBlock(point, set, true);
    }

    boolean checkDrawn() {
        for (char[] line : map)
            for (char point : line)
                if (point == DOT_EMPTY) return false;
        return true; // ничего не нашли, ничья.
    }

    void blockHuman() {
        for (int frame = set; frame > 1; frame--) { //перебираем размеры фреймов
            if (checkWinAndBlock(DOT_HUMAN, frame, false)) return;
        }
    }

    boolean checkFrame(int xFrame, int yFrame, int frame, char type) {

        switch (type) {
            case ('X'): // вертикальная линия
                if ((yFrame < size - 1) && (map[yFrame + 1][xFrame] == DOT_EMPTY)) { // под линией
                    aiX = yFrame + 1;
                    aiY = xFrame;
                    return true;
                }
                if ((yFrame - frame >= 0) && (map[yFrame - frame][xFrame] == DOT_EMPTY)) { // над линией
                    aiX = yFrame - frame;
                    aiY = xFrame;
                    return true;
                }
                break;
            case ('Y'): // горизонтальная линия
                if ((yFrame < size - 1) && (map[xFrame][yFrame + 1] == DOT_EMPTY)) { // справа от линии
                    aiX = xFrame;
                    aiY = yFrame + 1;
                    return true;
                }
                if ((yFrame - frame >= 0) && (map[xFrame][yFrame - frame] == DOT_EMPTY)) { // слева от линии
                    aiX = xFrame;
                    aiY = yFrame - frame;
                    return true;
                }
                break;
            case ('A')://главная диагональ
                if ((yFrame < size - 1) && (xFrame < size - 1)
                        && (map[xFrame + 1][yFrame + 1] == DOT_EMPTY)) { // справа от диагонали
                    aiX = xFrame + 1;
                    aiY = yFrame + 1;
                    return true;
                }
                if ((yFrame - frame >= 0) && (xFrame - frame >= 0)
                        && (map[xFrame - frame][yFrame - frame] == DOT_EMPTY)) { // слева от диагонали
                    aiX = xFrame - frame;
                    aiY = yFrame - frame;
                    return true;
                }
                break;
            case ('B')://вспомогательная диагональ
                if ((yFrame > 0) && (xFrame + 1 < size)
                        && (map[xFrame + 1][yFrame - 1] == DOT_EMPTY)) { // слева от вспом диагонали
                    aiX = xFrame + 1;
                    aiY = yFrame - 1;
                    return true;
                }
                if ((yFrame + frame <= size) && (xFrame - frame >= 0)
                        && (map[xFrame - frame][yFrame + frame] == DOT_EMPTY)) { // справа от вспом диагонали
                    aiX = xFrame - frame;
                    aiY = yFrame + frame;
                    return true;
                }
                break;
            case ('C')://между точками вертикально
                if (map[yFrame - 1][xFrame] == DOT_EMPTY) {
                    aiX = yFrame - 1;
                    aiY = xFrame;
                    return true;
                }
                break;
            case ('D')://между точками горизонтально
                if (map[xFrame][yFrame - 1] == DOT_EMPTY) { // справа от линии
                    aiX = xFrame;
                    aiY = yFrame - 1;
                    return true;
                }
                break;
            case ('E')://между точек главная диагональ
                if (map[xFrame - 1][yFrame - 1] == DOT_EMPTY) { // центр диагонали
                    aiX = xFrame - 1;
                    aiY = yFrame - 1;
                    return true;
                }
                break;
            case ('F')://между точек вспомогательная диагональ
                if (map[xFrame - 1][yFrame + 1] == DOT_EMPTY) { // центр вспом диагонали
                    aiX = xFrame - 1;
                    aiY = yFrame + 1;
                    return true;
                }
                break;
            default:
                System.out.println("Fatal error!))");
                break;
        }
        return false;
    }

}
