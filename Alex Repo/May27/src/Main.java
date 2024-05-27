import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException , FileNotFoundException {
        URL colorsURL = Main.class.getResource("colors.txt");
        URI colorsURI = colorsURL.toURI();

        File colorFile = new File(colorsURI);

        Scanner input = new Scanner(colorFile);

        List<String> colors = new ArrayList<>();

        while (input.hasNextLine()) {
            colors.add(input.nextLine());
        }

        System.out.println(colors);
    }
}
