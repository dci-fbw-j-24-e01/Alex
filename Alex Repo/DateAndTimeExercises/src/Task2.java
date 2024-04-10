import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task2 {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM");
        String text = date.format(formatter).toUpperCase();
        System.out.println(text);

        formatter = DateTimeFormatter.ofPattern("d");
        text = date.format(formatter).toUpperCase();
        System.out.println(text);

        System.out.println();

        date = date.plusMonths(6).plusDays(2).plusHours(7);
        formatter = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy");
        text = date.format(formatter).toUpperCase();
        System.out.println(text);

        formatter = DateTimeFormatter.ofPattern("M/d/yy");
        text = date.format(formatter).toUpperCase();
        System.out.println(text);

        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        text = date.format(formatter).toUpperCase();
        System.out.println(text);

        formatter = DateTimeFormatter.ofPattern("d MMMM yyyy");
        text = date.format(formatter).toUpperCase();
        System.out.println(text);
    }
}
