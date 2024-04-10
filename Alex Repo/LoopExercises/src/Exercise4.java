public class Exercise4 {
    public static void main(String[] args) {
        int a = 11;
        while (a-- > 1) {
            System.out.print(a);
            if (a > 1) {
                System.out.print(", ");
            }
        }
    }
}
