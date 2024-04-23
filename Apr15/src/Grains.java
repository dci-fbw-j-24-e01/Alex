import java.math.BigInteger;

class Grains {

    public static void main(String[] args) {
        grainsOnBoard();
    }

    public static void grainsOnBoard() {
        BigInteger sum = new BigInteger("0");
        BigInteger current = new BigInteger("1");
        for (int i = 1; i < 65; i++) {
            sum = sum.add(current);
            current = current.multiply(BigInteger.valueOf(2L));
        }
        System.out.println(sum);
    }

}