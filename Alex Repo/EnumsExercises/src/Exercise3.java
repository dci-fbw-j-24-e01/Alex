import java.util.Scanner;


public class Exercise3 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int mode;
        while (true) {
            System.out.println("Enter 1 for auto mode or 2 for manual control:");
            String input = scanner.nextLine();
            if (input.equals("1")) {
                mode = 1;
                break;
            } else if (input.equals("2")) {
                mode = 2;
                break;
            }
        }
        if (mode == 1) {
            autoMode();
        }
        else {
            manualMode();
        }
    }
    private static void autoMode() throws InterruptedException {
        System.out.println("Auto mode started.");
        int i = 0;
        TrafficLight[] lights = TrafficLight.values();

        while (true) {
            String message = "";
            switch (lights[i]) {
                case RED -> message = "Wait\n";
                case REDYELLOW -> message = "Prepare to go\n";
                case GREEN -> message = "GOOO!\n";
                case YELLOW -> message = "Stop\n";
            }
            System.out.print(message);
            i++;
            if (i == lights.length) {
                i = 0;
            }
            Thread.sleep(3000);
        }
    }

    private static void manualMode() {
        System.out.println("Manual mode started. Press ENTER to switch the Trafficlight.");
        System.out.println("Type 'exit' to stop the application.");
        int i = 0;
        TrafficLight[] lights = TrafficLight.values();

        while (true) {
            String message = "";
            switch (lights[i]) {
                case RED -> message = "Wait";
                case REDYELLOW -> message = "Prepare to go";
                case GREEN -> message = "GOOO!";
                case YELLOW -> message = "Stop";
            }
            System.out.print(message);
            i++;
            if (i == lights.length) {
                i = 0;
            }
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
}
