package main;

import control.Command;
import control.CommandInvoker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandInvoker invoker = new CommandInvoker(scanner);
        int choice;

        do {
            printMainMenu();
            try {
                choice = Integer.parseInt(scanner.nextLine());

                if (choice == 16) {
                    System.out.println("Thank you for using UnitingSA System. Goodbye!");
                    break;
                }

                Command command = invoker.getCommand(choice);
                if (command != null) {
                    command.execute();
                } else {
                    System.out.println("Invalid option. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                choice = -1;
            }

            System.out.println(); // spacing

        } while (true);

        scanner.close();
    }

    private static void printMainMenu() {
        System.out.println("============================================================");
        System.out.println("  Welcome to UnitingSA – Aged Care Management System");
        System.out.println("============================================================");
        System.out.println("Please choose an operation:");
        System.out.println("\n-- Resident Management --");
        System.out.println(" 1. Admit New Resident");
        System.out.println(" 2. Discharge Resident");
        System.out.println(" 3. List All Admitted Residents");
        System.out.println("\n-- Room Management --");
        System.out.println(" 4. Allocate Room to New Resident");
        System.out.println(" 5. Release Room after Discharge");
        System.out.println(" 6. View Room Status");
        System.out.println(" 7. Mark Room as Under Maintenance");
        System.out.println(" 8. Mark Room as Available (after maintenance)");
        System.out.println("\n-- Equipment Management --");
        System.out.println(" 9. Allocate Equipment to Resident");
        System.out.println("10. Report Faulty Equipment");
        System.out.println("11. View Equipment Status");
        System.out.println("\n-- Roster Management --");
        System.out.println("12. Create Weekly Roster");
        System.out.println("13. Add Schedule to Roster");
        System.out.println("14. Update Shift Assignment");
        System.out.println("15. View Roster");
        System.out.println("\n16. Exit");
        System.out.println("------------------------------------------------------------");
        System.out.print("Enter your choice: ");
    }
}
