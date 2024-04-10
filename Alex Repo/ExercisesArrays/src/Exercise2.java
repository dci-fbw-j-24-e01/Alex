public class Exercise2 {
    public static void main(String[] args) {
        int[] numbers = { 2, 5, 10, 6, 12, 20, 4, 15, 10 };
        if (numbers.length % 2 == 0) {
            System.out.println(numbers[numbers.length / 2 - 1] + numbers[numbers.length / 2]);
        }
        else
            System.out.println(numbers[numbers.length / 2]);
    }
}
