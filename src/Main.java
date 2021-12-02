import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        runDecember02();
    }

    public static void substrings(){
        String string = "hallo 123".replaceAll(" ", "");
        System.out.println(string.substring(string.length()-1, string.length()));
    }


    public static void runDecember02() throws IOException {
        LoadList loadList = new LoadList();
        List<String> data = loadList.loadList("December02.txt");
        December02 december02 = new December02();
        december02.splitList(data);
        december02.executeCommands();
        System.out.println(december02.getDepth() * december02.getHorizontal());
    }

    public static void runDecember01() throws IOException {
        LoadList loadList = new LoadList();
        List<Integer> data = loadList.convertListToInt(loadList.loadList01("December01.txt"));
        December01 december01 = new December01();
        List<Integer> list = december01.groupInThree(data);
        int increased = december01.calculateIncreased(list);
        System.out.println(increased);
    }
}
