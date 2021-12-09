import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class December09 {

    int[][] visited;

    public int calculateBasinSize(List<int[]> deepPoints, int[][] coordinates) {
        this.visited = new int[coordinates.length][coordinates[0].length];
        List<Integer> basinSizes = new ArrayList<>();
        for (int[] row : visited) {
            for (int number : row) {
                number = 0;
            }
        }
        for (int[] point : deepPoints) {
            basinSizes.add(fillBasin(coordinates, point));
        }
        Collections.sort(basinSizes);
        int basins = basinSizes.size();
        return basinSizes.get(basins - 1) * basinSizes.get(basins - 2) * basinSizes.get(basins - 3);
    }

    public int fillBasin(int[][] coordinates, int[] point) {
        int size = 0;
        int row = point[0];
        int column = point[1];

        if (visited[row][column] == 0) {
            visited[row][column] = 1;
            size++;
        }

        boolean above = false;
        boolean below = false;
        boolean left = false;
        boolean right = false;

        boolean checkAbove = true;
        boolean checkBelow = true;
        boolean checkLeft = true;
        boolean checkRight = true;

        if (row == 0) {
            checkAbove = false;
        } else if (row == coordinates.length - 1) {
            checkBelow = false;
        }
        if (column == 0) {
            checkLeft = false;
        } else if (column == coordinates[0].length - 1) {
            checkRight = false;
        }

        if (checkAbove && (visited[row - 1][column] == 0) && (coordinates[row - 1][column] != 9)) {
            visited[row - 1][column] = 1;
            above = true;
            size++;
        }
        if (checkBelow && (visited[row + 1][column] == 0) && (coordinates[row + 1][column] != 9)) {
            visited[row + 1][column] = 1;
            below = true;
            size++;
        }
        if (checkLeft && (visited[row][column - 1] == 0) && (coordinates[row][column - 1] != 9)) {
            visited[row][column - 1] = 1;
            left = true;
            size++;
        }
        if (checkRight && (visited[row][column + 1] == 0) && (coordinates[row][column + 1] != 9)) {
            visited[row][column + 1] = 1;
            right = true;
            size++;
        }

        if (above) {
            size += fillBasin(coordinates, new int[]{row - 1, column});
        }
        if (below) {
            size += fillBasin(coordinates, new int[]{row + 1, column});
        }
        if (left) {
            size += fillBasin(coordinates, new int[]{row, column - 1});
        }
        if (right) {
            size += fillBasin(coordinates, new int[]{row, column + 1});
        }

        return size;

    }

    public int calculateRisk(List<int[]> deepPoints, int[][] coordinates) {
        int risk = 0;
        for (int[] point : deepPoints) {
            risk = risk + coordinates[point[0]][point[1]] + 1;
        }
        return risk;
    }

    public List<int[]> getDeepPoints(int[][] coordinates) {
        List<int[]> deepPoints = new ArrayList<>();
        for (int row = 0; row < coordinates.length; row++) {
            if (row == 0) {
                if ((coordinates[row][1] > coordinates[row][0]) && (coordinates[row + 1][0] > coordinates[row][0])) {
                    deepPoints.add(new int[]{0, 0});
                }
                for (int column = 1; column < coordinates[row].length - 1; column++) {
                    int point = coordinates[row][column];
                    if ((coordinates[row][column - 1] > point) && (coordinates[row][column + 1] > point) && coordinates[row + 1][column] > point) {
                        deepPoints.add(new int[]{row, column});
                    }
                }
                int end = coordinates[row].length - 1;
                if ((coordinates[row][end - 1] > coordinates[row][end]) && (coordinates[row + 1][end] > coordinates[row][end])) {
                    deepPoints.add(new int[]{row, end});
                }
            } else if (row == coordinates.length - 1) {
                if ((coordinates[row][1] > coordinates[row][0]) && (coordinates[row - 1][0] > coordinates[row][0])) {
                    deepPoints.add(new int[]{row, 0});
                }
                for (int column = 1; column < coordinates[row].length - 1; column++) {
                    int point = coordinates[row][column];
                    if ((coordinates[row][column - 1] > point) && (coordinates[row][column + 1] > point) && coordinates[row - 1][column] > point) {
                        deepPoints.add(new int[]{row, column});
                    }
                }
                int end = coordinates[row].length - 1;
                if ((coordinates[row][end - 1] > coordinates[row][end]) && (coordinates[row - 1][end] > coordinates[row][end])) {
                    deepPoints.add(new int[]{row, end});
                }
            } else {
                if ((coordinates[row][1] > coordinates[row][0]) && (coordinates[row + 1][0] > coordinates[row][0]) && (coordinates[row - 1][0] > coordinates[row][0])) {
                    deepPoints.add(new int[]{row, 0});
                }
                for (int column = 1; column < coordinates[row].length - 1; column++) {
                    int point = coordinates[row][column];
                    if ((coordinates[row][column - 1] > point) && (coordinates[row][column + 1] > point) && coordinates[row + 1][column] > point && coordinates[row - 1][column] > point) {
                        deepPoints.add(new int[]{row, column});
                    }
                }
                int end = coordinates[row].length - 1;
                if ((coordinates[row][end - 1] > coordinates[row][end]) && (coordinates[row + 1][end] > coordinates[row][end]) && (coordinates[row - 1][end] > coordinates[row][end])) {
                    deepPoints.add(new int[]{row, end});
                }
            }


        }
        return deepPoints;
    }
}
