package facility_resource_management;

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

    public void registerCommand(int option, Command command) {
        commandMap.put(option, command);
    }

    public void showMenu() {
        System.out.println("\n========== Residential Aged Care Facility Resource Management ==========");

        System.out.println("\n-- Room Management --");
        System.out.println("1. Allocate Room to New Resident");
        System.out.println("2. Release Room after Discharge");
        System.out.println("3. View Room Status");
        System.out.println("4. Mark Room as Under Maintenance");
        System.out.println("5. Mark Room as Available (after maintenance)");

        System.out.println("\n-- Equipment Management --");
        System.out.println("6. Allocate Equipment to Resident");
        System.out.println("7. Report Faulty Equipment");
        System.out.println("8. View Equipment Status");

        System.out.println("\n-- Roster Management --");
        System.out.println("9. Create Weekly Roster");
        System.out.println("10. Add Schedule to Roster");
        System.out.println("11. Update Shift Assignment");
        System.out.println("12. View Roster");

        System.out.println("\n0. Exit");
        System.out.println("---------------------------------------------------------------");
        System.out.print("Enter your choice: ");
    }

    public void run() {
        boolean running = true;

        while (running) {
            showMenu();
            int choice;

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
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
