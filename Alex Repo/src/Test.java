import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Long> bytes = Arrays.asList(0x80L);
        List<String> expected = List.of ("0x81", "0x0");

        VariableLengthQuantity test = new VariableLengthQuantity();
        System.out.println(test.encode(bytes));
        System.out.println(expected);
    }
}
