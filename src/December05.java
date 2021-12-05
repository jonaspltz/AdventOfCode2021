import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class December05 {

    private static final int size = 1000;

    public int countOverlappingPoints(int[][] field) {
        int counter = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (field[y][x] > 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int[][] drawLines(List<int[]> coordinates) {
        int[][] field = new int[size][size];
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                field[y][x] = 0;
            }
        }
        for (int[] coordinate : coordinates) {
            int x1 = coordinate[0];
            int y1 = coordinate[1];
            int x2 = coordinate[2];
            int y2 = coordinate[3];
            if (x1 != x2 && y1 != y2) {
                if (x1 < x2 && y1 < y2) {
                    for (int i = 0; i <= (x2 - x1); i++) {
                        field[y1 + i][x1 + i]++;
                    }
                } else if (x1 < x2) {
                    for (int i = 0; i <= (x2 - x1); i++) {
                        field[y1 - i][x1 + i]++;
                    }
                } else if (y1 < y2) {
                    for (int i = 0; i <= (x1 - x2); i++) {
                        field[y1 + i][x1 - i]++;
                    }
                } else {
                    for (int i = 0; i <= (x1 - x2); i++) {
                        field[y1 - i][x1 - i]++;
                    }
                }
            } else {
                if (x1 == x2) {
                    if (y1 < y2) {
                        for (int y = y1; y <= y2; y++) {
                            field[y][x1]++;
                        }
                    } else if (y1 > y2) {
                        for (int y = y2; y <= y1; y++) {
                            field[y][x1]++;
                        }
                    } else {
                        field[y1][x1]++;
                    }
                } else {
                    if (x1 < x2) {
                        for (int x = x1; x <= x2; x++) {
                            field[y1][x]++;
                        }
                    } else {
                        for (int x = x2; x <= x1; x++) {
                            field[y1][x]++;
                        }
                    }
                }
            }
        }

        return field;
    }

    public List<int[]> convertRowsToCoordinates(List<String> rows) {
        List<int[]> coordinates = new ArrayList<>();
        for (String row : rows) {
            Scanner sc = new Scanner(row);
            sc.useDelimiter(",| -> ");
            int[] line = new int[4];
            for (int i = 0; i < 4; i++) {
                line[i] = Integer.parseInt(sc.next());
            }
            coordinates.add(line);
        }
        return coordinates;
    }
}
