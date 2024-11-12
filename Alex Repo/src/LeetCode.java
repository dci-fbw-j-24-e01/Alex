import java.util.HashMap;
import java.util.Map;

public class LeetCode {
    public int romanToInt(String s) {
        Map<String, Integer> combinations = Map.of("IV", 4, "IX", 9, "XL", 40, "XC", 90, "CD", 400, "CM", 900);
        Map<String, Integer> values = Map.of("I", 1, "V", 5, "X", 10, "L", 50, "C", 100, "D", 500, "M", 1000);

        int result = 0;

        for (Map.Entry<String, Integer> entry : combinations.entrySet()) {

        }
    }

    public static void main(String[] args) {
    }
}
