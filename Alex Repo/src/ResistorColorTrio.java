public class ResistorColorTrio {
    public String truncate(String input) {
        if (input.length() < 6) return input;
        StringBuilder sb = new StringBuilder(input);
        sb.delete(5, input.length());
        return sb.toString();
    }
}

