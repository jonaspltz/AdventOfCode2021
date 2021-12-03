import java.util.List;

public class December03 {


    public String lifeSupport(List<String> data, int value) {
        int position = 0;
        while (data.size() > 1) {
            char mostCommonBit = this.buildValues(data)[value].charAt(position);
            int finalPosition = position;
            data.removeIf(n -> (n.charAt(finalPosition) != mostCommonBit));
            position++;
            if (position > data.get(0).length() - 1) {
                position = 0;
            }
        }
        return data.get(0);
    }

    public int binaryToInteger(String binary) {
        int integer = 0;

        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                integer = integer + (int) Math.pow(2, binary.length() - i - 1);
            }
        }
        return integer;
    }

    public String[] buildValues(List<String> data) {
        StringBuilder gammaValue = new StringBuilder();
        StringBuilder epsilonValue = new StringBuilder();
        for (int outer = 0; outer < data.get(0).length(); outer++) {
            int zeros = 0;
            int ones = 0;
            for (String value : data) {
                switch (value.charAt(outer)) {
                    case '0':
                        zeros++;
                        break;
                    case '1':
                        ones++;
                        break;
                }
            }
            if (zeros > ones) {
                gammaValue.append("0");
                epsilonValue.append("1");
            } else {
                gammaValue.append("1");
                epsilonValue.append("0");
            }
        }
        return new String[]{gammaValue.toString(), epsilonValue.toString()};
    }


}
