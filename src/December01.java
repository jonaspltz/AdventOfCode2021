import java.util.ArrayList;
import java.util.List;

public class December01 {

    public List<Integer> groupInThree(List<Integer> data) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i < data.size() - data.size() % 3 + 2; i++) {
            list.add(data.get(i) + data.get(i - 1) + data.get(i - 2));
        }

        return list;
    }

    public int calculateIncreased(List<Integer> list) {
        int increasedCounter = 0;
        System.out.println(list.get(0));
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i) > list.get(i - 1)) {
                increasedCounter++;
                System.out.println(list.get(i) + " increased");
            } else {
                System.out.println(list.get(i));
            }
        }
        return increasedCounter;
    }
}
