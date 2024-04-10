public class Exercise10 {
    public static void main(String[] args) {
        for (int i = 1900; i <= 2100; i += 4) {
            if (i % 400 == 0 || i % 100 != 0) {
                System.out.println(i);
            }
        }
    }
}
