public class Exercise7 {
    public static void main(String[] args) {
        String[] names = { "Josie", "Cathrin", "Bob", "Max", "Hannah", "Alex" };
        int index = 0, max = 0;
        for (int i = 0; i < names.length; i++) {
            if (names[i].length() > max) {
                max = names.length;
                index = i;
            }
        }
        System.out.println(names[index]);
    }
}
