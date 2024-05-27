import java.util.List;
import java.util.ArrayList;

class VariableLengthQuantity {

    List<String> encode(List<Long> numbers) {
        List<String> numbersString = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (Long number : numbers) {
            sb.insert(0, number);
        }

        boolean finished = false;
        for (int i = sb.length(); !finished; i -= 7) {
            String substring = sb.substring(Math.max(0, i - 8), i);
            numbersString.addFirst(substring);

        }

        return numbersString;
    }

    List<String> decode(List<Long> bytes) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }
}