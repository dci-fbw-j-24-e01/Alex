public class Exercise5 {
    public static void main(String[] args) {
        int[] numbers = { 2, 5, 10, 6, 3, 12, 20, 4, 15, 10 };
        int n = 35;
        System.out.println(contains(numbers, n));
    }

    public static boolean contains(int[] source, int n) {
        for (int i = 0; i < source.length; i++) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }
}
