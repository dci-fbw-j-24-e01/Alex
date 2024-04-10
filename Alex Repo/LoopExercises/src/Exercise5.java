public class Exercise5 {
    public static void main(String[] args) {
        int a = 0;
        while (a++ < 12) {
            System.out.print(a + " ");
            if (a % 3 == 0) {
                System.out.print("TAP! ");
            }
        }
    }
}
