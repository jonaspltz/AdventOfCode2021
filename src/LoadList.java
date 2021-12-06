import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadList {

    public List<Integer> loadLanternFish(String file) throws IOException {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            list.add(Integer.parseInt(sc.next()));
        }
        return list;
    }

    public List<int[][]> loadBingoBoards(String file) throws IOException {
        int numberOfBoards = this.countBoards(file);
        List<int[][]> list = new ArrayList<>();
        Scanner sc1 = new Scanner(new File(file));
        sc1.useDelimiter("\r\n");
        sc1.next();
        for (int outer = 0; outer < numberOfBoards; outer++) {
            int[][] board = new int[5][5];
            if (list.size() < 100) {
                sc1.next();
            } else {
                continue;
            }
            for (int rows = 0; rows < 5; rows++) {
                String row = sc1.next();
                Scanner sc2 = new Scanner(row);
                for (int columns = 0; columns < 5; columns++) {
                    int next = sc2.nextInt();
                    board[rows][columns] = next;
                }
            }
            list.add(board);
        }
        return list;
    }

    public int countBoards(String file) throws IOException {
        int counter = 0;
        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter("\r\n");
        while (sc.hasNext()) {
            String row = sc.next();
            if (row.equals("")) {
                counter++;
            }
        }
        return counter;
    }

    public List<Integer> rowToList04(String file) throws IOException {
        List<Integer> list = new ArrayList<>();
        Scanner sc1 = new Scanner(new File(file));
        sc1.useDelimiter("\r\n");
        String row = sc1.next();
        sc1.close();
        Scanner sc2 = new Scanner(row);
        sc2.useDelimiter(",");
        while (sc2.hasNext()) {
            list.add(Integer.valueOf(sc2.next()));
        }
        sc2.close();
        return list;

    }

    public List<String> loadList(String file) throws IOException {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter("\r\n");
        while (sc.hasNext()) {
            String next = sc.next();
            list.add(next);
        }
        sc.close();

        return list;
    }

    public List<Integer> convertListToInt(List<String> data) {
        List<Integer> list = new ArrayList<>();
        for (String value : data) {
            list.add(Integer.valueOf(value));
        }
        return list;
    }
}
