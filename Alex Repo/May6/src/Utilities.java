import java.util.Random;

public class Utilities {

    private static final String SOURCE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_!$@";
    private static final Random RANDOM = new Random();

    public static String generatePassword(int length, String sourceLetters) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int randomNumber = RANDOM.nextInt(0, sourceLetters.length());
            password.append(sourceLetters.charAt(randomNumber));
        }
        return password.toString();
    }

    public static String generatePassword(int length) {
        return generatePassword(length, SOURCE_LETTERS);
    }

    public static String generatePassword() {
        return generatePassword(10, SOURCE_LETTERS);
    }

}
