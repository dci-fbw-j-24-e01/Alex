public class Exercise8 {
    public static void main(String[] args) {
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                int mul = i * j;
                if (mul < 10) {
                    System.out.print("   " + mul);
                }
                else if (mul < 100) {
                    System.out.print("  " + mul);
                }
                else System.out.print(" " + mul);
            }
            System.out.println();
        }
    }
}
