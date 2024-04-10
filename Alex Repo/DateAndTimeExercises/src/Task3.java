import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class Task3 {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate exam = LocalDate.of(2024, 10, 11);
        Period period = Period.between(today, exam);
        int months = period.getMonths();
        int days = period.getDays();
        System.out.print(months + " Months and " + days + " day");
        if (days % 10 != 1 && days % 100 != 11) {
            System.out.print("s");
        }
        System.out.println(".");

        long daysLeft = ChronoUnit.DAYS.between(today, exam);
        System.out.print(daysLeft + " Day");
        if (daysLeft % 10 != 1 && daysLeft % 100 != 11) {
            System.out.print("s");
        }
        System.out.println(".");

        long hoursLeft = daysLeft * 24 - LocalTime.now().getHour() - 1;
        System.out.println(hoursLeft);

        long minutesLeft = hoursLeft * 60 - LocalTime.now().getMinute() - 1;
        System.out.println(minutesLeft);
    }
}