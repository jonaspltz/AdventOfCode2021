import java.util.List;

public class December06 {

    public long simulateGrowth(List<Integer> list, int days) {
        long[] ages = new long[9];
        for (int fish : list) {
            ages[fish]++;
        }
        for (int outer = 0; outer < days; outer++) {
            long[] copy = ages.clone();
            for (int inner = ages.length - 1; inner >= 0; inner--) {
                if (inner != 0) {
                    ages[inner - 1] = copy[inner];
                } else {
                    ages[6] = ages[6] + copy[inner];
                    ages[8] = copy[inner];
                }
            }


        }

        long sum = 0;
        for (long fish : ages) {
            sum += fish;
        }
        return sum;
    }
}
