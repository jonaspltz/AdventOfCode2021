import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class December08 {

    public int count(List<List<String>> output, List<HashMap> mappings) {
        int counter = 0;
        for (int outer = 0; outer < output.size(); outer++) {
            HashMap<Integer, String> map = mappings.get(outer);
            StringBuilder out = new StringBuilder();
            for (String number : output.get(outer)) {

                for (int inner = 0; inner < 10; inner++) {
                    if ((this.getMatchingChars(number, map.get(inner)) == number.length()) && (this.getMatchingChars(number, map.get(inner)) == map.get(inner).length())) {
                        out.append(inner);
                    }
                }

            }
            counter = counter + Integer.parseInt(out.toString());
        }
        return counter;
    }


    public List<HashMap> mapping(List<List<String>> numbers) {
        List<HashMap> maps = new ArrayList<>();
        for (List<String> strings : numbers) {
            HashMap<Integer, String> pattern = new HashMap<>();
            for (String number : strings) {
                switch (number.length()) {
                    case 2:
                        pattern.put(1, number);
                        break;
                    case 3:
                        pattern.put(7, number);
                        break;
                    case 4:
                        pattern.put(4, number);
                        break;
                    case 7:
                        pattern.put(8, number);
                        break;
                }
            }
            for (String number : strings) {
                if (number.length() == 5) {
                    if (this.getMatchingChars(number, pattern.get(1)) == 2) {
                        pattern.put(3, number);
                    }
                }
            }
            for (String number : strings) {
                if (number.length() == 6) {
                    if (this.getMatchingChars(number, pattern.get(3)) == 5) {
                        pattern.put(9, number);
                    }
                }
            }

            for (String number : strings) {
                if (number.length() == 5) {
                    int matching = this.getMatchingChars(number, pattern.get(4));
                    if (matching == 2) {
                        pattern.put(2, number);
                    } else if (matching == 3 && !number.equals(pattern.get(3))) {
                        pattern.put(5, number);
                    }
                }
            }
            for (String number : strings) {
                if (number.length() == 6) {
                    if (this.getMatchingChars(number, pattern.get(5)) == 5 && !number.equals(pattern.get(9))) {
                        pattern.put(6, number);
                    }
                }
            }
            for (String number : strings) {
                if (number.length() == 6) {
                    if (!(this.getMatchingChars(number, pattern.get(6)) == 6) && !(this.getMatchingChars(number, pattern.get(9)) == 6)) {
                        pattern.put(0, number);
                    }
                }
            }
            maps.add(pattern);
        }
        return maps;
    }

    public int getMatchingChars(String one, String two) {
        int counter = 0;
        for (int outer = 0; outer < one.length(); outer++) {
            for (int inner = 0; inner < two.length(); inner++) {
                if (one.charAt(outer) == two.charAt(inner)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public int countNumbers(List<List<String>> numbers) {
        int counter = 0;
        for (List<String> list : numbers) {
            for (String number : list) {
                switch (number.length()) {
                    case 2:
                    case 3:
                    case 4:
                    case 7:
                        counter++;
                        break;
                }
            }
        }
        return counter;
    }
}
