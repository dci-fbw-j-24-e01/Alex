public class Exercise3 {
    public static void main(String[] args) {
        int a = 3;
        while (a < 31) {
            System.out.print(a);
            if (a < 30) {
                System.out.print(", ");
            }
            a += 3;
        }
    }
}
