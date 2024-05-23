import java.util.List;
import java.util.ArrayList;

class SumOfMultiples {
    private final int level;
    private final int[] set;

    SumOfMultiples(int number, int[] set) {
        level = number;
        this.set = set;
    }

    int getSum() {
        List<Integer> ints = new ArrayList<>();
        for (int i = 0; i < set.length; i++) {
            int multiplyer = 1;
            int toAdd = set[i] * multiplyer;
            while (toAdd < level) {
                if (!ints.contains(toAdd)) {
                    ints.add(toAdd);
                }
                multiplyer++;
                toAdd = set[i] * multiplyer;
            }
        }

        int sum = 0;

        for (int i : ints) {
            sum += i;
        }
        return sum;
    }

}
