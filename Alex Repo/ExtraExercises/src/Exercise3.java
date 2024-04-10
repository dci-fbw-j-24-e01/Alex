import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = scanner.nextLine();
        System.out.println(dash(input));
    }

    public static String dash(String source) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i > 0) {
                sb.append('-');
            }
            sb.append(source.charAt(i));
        }
        return sb.toString();
    }
}

