public class Exercise11 {
    public static void main(String[] args) {
        int lastNum = 0;
        int currentNum = 1;
        System.out.print(lastNum + currentNum + " ");
        for (int i = 0; i < 19; i++) {
            int sum = lastNum + currentNum;
            System.out.print(sum + " ");
            lastNum = currentNum;
            currentNum = sum;
        }
    }
}
