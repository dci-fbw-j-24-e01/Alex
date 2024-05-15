public class IncorrectProductIdException extends Exception {
    long incorrectNumber;

    public IncorrectProductIdException(long incorrectNumber) {
        this.incorrectNumber = incorrectNumber;
    }

    public String getMessage() {
        return "There is an incorrect productId " + incorrectNumber;
    }
}
