import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        runDecember04();
    }

    public static void runDecember04() throws IOException {
        LoadList loadList = new LoadList();
        List<Integer> numbers = loadList.rowToList04("December04.txt");
        List<int[][]> boards = loadList.loadBingoBoards("December04.txt");
        December04 december04 = new December04();
        december04.winningBoard(numbers, boards);
        december04.winningBoardLast(numbers, boards);
    }

    public static void runDecember03() throws IOException {
        LoadList loadList = new LoadList();
        List<String> data = loadList.loadList("December03.txt");
        December03 december03 = new December03();
        String[] values = december03.buildValues(data);
        int gamma = december03.binaryToInteger(values[0]);
        int epsilon = december03.binaryToInteger(values[1]);
        System.out.println("consumption: " + gamma * epsilon);

        List<String> oxygenRatingList = new ArrayList<>(data);
        List<String> co2RatingList = new ArrayList<>(data);
        String oxygenRating = december03.lifeSupport(oxygenRatingList, 0);
        String co2Rating = december03.lifeSupport(co2RatingList, 1);
        System.out.println("Life Support: " + (december03.binaryToInteger(oxygenRating) * december03.binaryToInteger(co2Rating)));
    }


    public static void runDecember02() throws IOException {
        LoadList loadList = new LoadList();
        List<String> data = loadList.loadList("December02.txt");
        December02 december02 = new December02();
        december02.splitList(data);
        december02.executeCommands();
        System.out.println("course: " + (december02.getDepth() * december02.getHorizontal()));
    }

    public static void runDecember01() throws IOException {
        LoadList loadList = new LoadList();
        List<Integer> data = loadList.convertListToInt(loadList.loadList("December01.txt"));
        December01 december01 = new December01();
        List<Integer> list = december01.groupInThree(data);
        int increased = december01.calculateIncreased(list);
        System.out.println("increased: " + increased);
    }
}
