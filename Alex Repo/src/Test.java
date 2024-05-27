import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Long> numbers = List.of(0x40L, 0x7fL);

        VariableLengthQuantity test = new VariableLengthQuantity();
        System.out.println(test.encode(numbers));
    }
}
