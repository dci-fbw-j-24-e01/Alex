import java.util.Scanner;

public class NumberPlateValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Registration plate number in format XXX-YYY");
        String input = scanner.nextLine();
        boolean valid = isRegistrationNumberValid(input);
        System.out.println("The registration plate number is "  + (valid ? "valid" : "invalid"));
    }

    private static boolean isRegistrationNumberValid(String plate) {
        if (plate == null) {
            return false;
        }
        if (plate.charAt(3) != '-') {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (plate.charAt(i) < 'A' || plate.charAt(i) > 'Z') {
                return false;
            }
        }
        try {
            Integer.parseInt(plate.substring(4));
        }
        catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}
