package record;

import control.*;
import manager.AdmissionManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().start();
    }

    private final Scanner scanner = new Scanner(System.in);
    private final AdmissionManager manager = AdmissionManager.getInstance();
    private final CommandHandler handler = new CommandHandler();

    public void start() {
        System.out.println("=== UnitingSA Admission System ===");
        System.out.println(handler.getHelp());

        while (true) {
            System.out.print("\n> ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) continue;

            ParsedInput parsed = handler.parse(input);
            if (parsed.getCommand().equals("exit")) break;

            CommandResponse response = handler.execute(
                parsed.getCommand(),
                parsed.getArgs(),
                manager
            );

            System.out.println(response.getMessage());
        }
    }
}