

public class Test {
    public static void main(String[] args) {
        int start = 12;
        int counter = 0;
        while(start > 1) {
            if (start % 2 == 0) {
                start /= 2;
            } else {
                start = start * 3 + 1;
            }
            counter++;
        }
        System.out.println(counter);
    }
}
