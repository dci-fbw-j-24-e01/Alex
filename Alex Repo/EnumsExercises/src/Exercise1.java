public class Exercise1 {
    public static void main(String[] args) {
        Day[] days = Day.values();
        for (Day day : days) {
            String message = "";

            switch (day) {
                case MONDAY -> message = "Uuugh!\n";
                case TUESDAY -> message = "TT Aaaah Yeeeaaahh!\n";
                case WEDNESDAY -> message = "We like Wednesday fika!\n";
                case THURSDAY -> message = "Almost there!\n";
                case FRIDAY -> message = "WHOOP WHOOP!\n";
            }
            System.out.print(message);
        }
    }
}
