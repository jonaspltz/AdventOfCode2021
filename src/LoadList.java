import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadList {

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
