public class PasswordGenerator {
    public static void main(String[] args) {
        String password = Utilities.generatePassword();
        System.out.println(password);
        password = Utilities.generatePassword(25);
        System.out.println(password);
        password = Utilities.generatePassword(15, "ABCabc");
        System.out.println(password);
    }
}
