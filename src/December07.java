import java.util.ArrayList;
import java.util.List;

public class December07 {

    public int calculateFuel(List<Integer> list, int height) {
        int fuel = 0;
        for (int crab : list) {
            int difference;
            if (crab > height) {
                difference = crab - height;
            } else if (height > crab) {
                difference = height - crab;
            } else {
                continue;
            }
            for (int i = 1; i <= difference; i++) {
                fuel += i;
            }
        }
        return fuel;
    }

    public int calculateHeight(List<Integer> list) {
        List<Integer> fuelOptions = new ArrayList<>();
        for (int crab : list) {
            if (!fuelOptions.contains(crab)) {
                fuelOptions.add(crab);
            }
        }
        int minFuel = this.calculateFuel(list, fuelOptions.get(0));
        for (int option : fuelOptions) {
            int calculatedFuel = this.calculateFuel(list, option);
            if (calculatedFuel < minFuel) {
                minFuel = calculatedFuel;
            }
        }
        return minFuel;
    }
}
