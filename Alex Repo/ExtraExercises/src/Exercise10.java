public class Exercise10 {
    public static void main(String[] args) {
        int goal = 5;
        for (int i = 2; goal > 0; i += 2) {
            int checking = (int) (Math.pow(2, i - 1) * (Math.pow(2, i) - 1));
            int sum = 0;
            for (int j = 1; j <= checking / 2; j++) {
                if (checking % j == 0) {
                    sum += j;
                }
            }
            if (sum == checking) {
                System.out.println(checking);
                goal--;
            }
            if (i == 2) {
                i--;
            }
        }
    }
}
