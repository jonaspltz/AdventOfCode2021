import java.util.List;

public class December04 {

    public void winningBoardLast(List<Integer> numbers, List<int[][]> boards) {
        for (Integer number : numbers) {
            for (int inner = 0; inner < boards.size(); inner++) {
                int[][] board = boards.get(inner);
                for (int row = 0; row < 5; row++) {
                    for (int column = 0; column < 5; column++) {
                        if (board[row][column] == number) {
                            board[row][column] = 100;
                        }
                    }
                }
                if (this.checkWon(board)) {
                    if (boards.size() > 1) {
                        boards.remove(inner);
                        inner--;
                    } else {
                        for (int[][] everyBoard : boards) {
                            System.out.println("Board number: " + (inner + 1));
                            System.out.println("Winning Board:");
                            printBoard(everyBoard);
                            System.out.println("last number: " + number);
                            System.out.println();
                            System.out.println("Score: " + this.calculateScore(everyBoard, number));
                        }
                        return;
                    }
                }
            }
        }
    }

    public void winningBoard(List<Integer> numbers, List<int[][]> boards) {
        for (Integer number : numbers) {
            for (int inner = 0; inner < boards.size(); inner++) {
                int[][] board = boards.get(inner);
                for (int row = 0; row < 5; row++) {
                    for (int column = 0; column < 5; column++) {
                        if (board[row][column] == number) {
                            board[row][column] = 100;
                        }
                    }
                }
                if (this.checkWon(board)) {
                    System.out.println("Board number: " + (inner + 1));
                    System.out.println("Winning Board:");
                    printBoard(board);
                    System.out.println("last number: " + number);
                    System.out.println();
                    System.out.println("Score: " + this.calculateScore(board, number));
                    return;
                }
            }
        }
    }

    public int calculateScore(int[][] board, int multiplication) {
        int sum = 0;
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                if (board[row][column] != 100) {
                    sum = sum + board[row][column];
                }
            }
        }
        return sum * multiplication;
    }

    public void printBoard(int[][] board) {
        for (int row = 0; row < 5; row++) {
            for (int column = 0; column < 5; column++) {
                if (board[row][column] != 100) {
                    System.out.print("\u001B[0m" + board[row][column] + " ");
                } else {
                    System.out.print("\u001B[32m" + board[row][column] + " ");
                }
            }
            System.out.println("\u001B[0m");
        }
    }

    public boolean checkWon(int[][] board) {
        boolean won;
        for (int row = 0; row < 5; row++) {
            won = true;
            for (int column = 0; column < 5; column++) {
                if (board[row][column] != 100) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return true;
            }
        }

        for (int column = 0; column < 5; column++) {
            won = true;
            for (int row = 0; row < 5; row++) {
                if (board[row][column] != 100) {
                    won = false;
                    break;
                }
            }
            if (won) {
                return true;
            }
        }
        return false;
    }
}
