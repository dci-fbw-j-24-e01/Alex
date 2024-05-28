import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        String content = "";
        try {
            content = Files.readString(Path.of("FilesExercises/resources/customers-100000.csv"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Customer> customers = new ArrayList<>();
        List<String> strings = Arrays.asList(content.split("\n"));

        for (int i = 1; i < strings.size(); i++) {
            String[] info = strings.get(i).split(",");
            if (info.length > 12) {
                info = getCustomerInfo(info);
            }

            LocalDate date = LocalDate.parse(info[10], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            URL url = null;
            try {
                url = new URL(info[11]);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            customers.add(new Customer(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]
                    , info[9], date, url));
        }

        int fromFrance = 0;
        int subscribedIn2020 = 0;

        for (Customer customer : customers) {
            if (customer.country().equals("France")) {
                fromFrance++;
            }
            if (customer.subscriptionDate().getYear() == 2020) {
                subscribedIn2020++;
            }
        }

        System.out.println("There is " + fromFrance + " " + (fromFrance > 1 ? "people" : "person") + " from France.");
        System.out.println("There is " + subscribedIn2020 + " " + (subscribedIn2020 > 1 ? "people" : "person")
                + " subscribed in 2020.");
    }

    private static String[] getCustomerInfo(String[] wrong) {
        String[] info = new String[12];
        int wrongIndex = 0;

        for (int i = 0; i < 12; i++, wrongIndex++) {
            if (!wrong[wrongIndex].startsWith("\"")) {
                info[i] = wrong[wrongIndex];
            } else {
                while(!wrong[wrongIndex].endsWith("\"")) {
                    info[i] = info[i] + wrong[wrongIndex++];
                }
            }
        }

        return info;
    }
}
