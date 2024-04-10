public class Exercise2 {
    public static void main(String[] args) {
        Day[] days = Day.values();
        for (Day day : days) {
            String message = "";

            switch (day) {
                case MONDAY -> message = "Uuugh!\n";
                case TUESDAY -> message = "TT Aaaah Yeeeaaahh!\n";
                case WEDNESDAY -> message = "We like Wednesday fika!\n";
                case LITTLE_SATURDAY -> message = "See you at Ugglan!\n";
                case THURSDAY -> message = "Almost there!\n";
                case FRIDAY -> message = "WHOOP WHOOP!\n";
                case CATURDAY -> message = ":3\n";
                case SATURDAY -> message = "See you in town!\n";
                case SUNDAY -> message = "Edward Blom and online pizza\n";
                case SUITDAY -> message = "Haters gonna hate\n";
            }
            System.out.print(message);
        }
    }
}
