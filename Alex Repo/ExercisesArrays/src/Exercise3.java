import java.util.Arrays;

public class Exercise3 {
    public static void main(String[] args) {
        int[] numbers = { 2, 5, 10, 6, 3, 12, 20, 4, 15, 10 };
        System.out.println(Arrays.toString(reverse(numbers)));
    }

    public static int[] reverse(int[] source) {
        int[] result = new int[source.length];
        for (int i = 0; i < source.length; i++) {
            result[i] = source[source.length - 1 - i];
        }
        return result;
    }
}
