import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadList {

    public int[][] loadTo2dArray(String file) throws IOException {
        List<String> rows = this.loadList(file);
        int[][] coordinates = new int[rows.size()][rows.get(0).length()];
        for (int outer = 0; outer < rows.size(); outer++) {
            for (int inner = 0; inner < rows.get(outer).length(); inner++) {
                coordinates[outer][inner] = Integer.parseInt(String.valueOf(rows.get(outer).charAt(inner)));
            }
        }

        return coordinates;
    }


    public List<List<String>> loadInputValue(String file) throws IOException {
        List<List<String>> inputValue = new ArrayList<>();
        Scanner sc1 = new Scanner(new File(file));
        sc1.useDelimiter("\r\n");
        List<String> rows = new ArrayList<>();
        while (sc1.hasNext()) {
            rows.add(sc1.next());
        }
        sc1.close();
        for (String row : rows) {
            Scanner sc2 = new Scanner(row.substring(0, 59));
            sc2.useDelimiter(" ");
            List<String> rowOutput = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                rowOutput.add(sc2.next());
            }
            inputValue.add(rowOutput);
            sc2.close();
        }

        return inputValue;
    }

    public List<List<String>> loadOutputValue(String file) throws IOException {
        List<List<String>> outputValue = new ArrayList<>();
        Scanner sc1 = new Scanner(new File(file));
        sc1.useDelimiter("\r\n");
        List<String> rows = new ArrayList<>();
        while (sc1.hasNext()) {
            rows.add(sc1.next());
        }
        sc1.close();
        for (String row : rows) {
            Scanner sc2 = new Scanner(row.substring(61));
            sc2.useDelimiter(" ");
            List<String> rowOutput = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                rowOutput.add(sc2.next());
            }
            outputValue.add(rowOutput);
            sc2.close();
        }


        return outputValue;
    }

    public List<Integer> loadLanternFish(String file) throws IOException {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter(",");
        while (sc.hasNext()) {
            list.add(Integer.parseInt(sc.next()));
        }
        sc.close();
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
                sc2.close();
            }
            list.add(board);
        }

        sc1.close();
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
        sc.close();
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
