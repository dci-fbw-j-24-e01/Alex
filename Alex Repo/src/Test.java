
public class Test {
    public static void main(String[] args) {
        LuhnValidator validator = new LuhnValidator();
        System.out.println(validator.isValid("055 444 285"));
    }
}
