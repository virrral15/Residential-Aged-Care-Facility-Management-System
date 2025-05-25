package FRMS;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandInvoker {
    private Map<Integer, Command> commandMap;
    private Scanner scanner;

    public CommandInvoker() {
        commandMap = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    // Register commands with numeric keys
    public void registerCommand(int option, Command command) {
        commandMap.put(option, command);
    }

    // Display menu options
    public void showMenu() {
        System.out.println("\n========== Facility Resource Management ==========");
        System.out.println("1. Allocate Room to New Resident");
        System.out.println("2. Release Room after Discharge");
        System.out.println("3. View Room Status");
        System.out.println("4. Allocate Equipment to Resident");
        System.out.println("5. Report Faulty Equipment");
        System.out.println("6. View Equipment Status");
        System.out.println("7. Create Weekly Roster");
        System.out.println("8. Add Schedule to Roster");
        System.out.println("9. Update Shift Assignment");
        System.out.println("10. View Roster");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------------------");
        System.out.print("Enter your choice: ");
    }

    // Main loop
    public void run() {
        boolean running = true;
        while (running) {
            showMenu();
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                continue;
            }

            if (choice == 0) {
                System.out.println("👋 Exiting system. Thank you!");
                running = false;
            } else if (commandMap.containsKey(choice)) {
                commandMap.get(choice).execute();
            } else {
                System.out.println("❌ Invalid option. Please try again.");
            }
        }
    }
}
