import java.util.List;
import java.util.ArrayList;

class Sieve {
    private final int max;
    Sieve(int maxPrime) {
        max = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> ints = new ArrayList<>();
        List<Boolean> mark = new ArrayList<>();

        if (max < 2) {
            return ints;
        }

        for (int i = 2; i <= max; i++) {
            ints.add(i);
            mark.add(false);
        }

        for(int i = 0; i < ints.size(); i++) {
            if (!mark.get(i)) {
                int multiplyer = 2;
                while (ints.get(i) * multiplyer <= max) {
                    mark.set(ints.get(i) * multiplyer - 2, true);
                    multiplyer++;
                }
            }
        }
        
        for (int i = ints.size() - 1; i >= 0; i--) {
            if (mark.get(i)) {
                ints.remove(i);
            }
        }

        return ints;
    }
}
