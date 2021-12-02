import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadList {

    public List<String> loadList(String file) throws IOException {
        List<String> list = new ArrayList<>();
        int i = 0;
        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter("\r\n");
        while (sc.hasNext()) {
            String next = sc.next();
            list.add(next);
            i++;
        }
        sc.close();

        return list;
    }
    public List<String> loadList01(String file) throws IOException {
        List<String> list = new ArrayList<>();
        int i = 0;
        Scanner sc = new Scanner(new File(file));
        sc.useDelimiter("\r\n");
        while (sc.hasNext()) {
            String next = sc.next();
            if (i == 0) {
                next = next.substring(1, 4);
            }
            list.add(next);
            i++;
        }
        sc.close();

        return list;
    }

    public List<Integer> convertListToInt(List<String> data){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < data.size(); i++){
            list.add(Integer.valueOf(data.get(i)));
        }
        return list;
    }
}
