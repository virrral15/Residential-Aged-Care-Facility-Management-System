package admission.record;

import admission.control.*;
import admission.manager.AdmissionManager;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandHandler handler = new CommandHandler();
        InputParser parser = new InputParser();
        
        System.out.println("Welcome to Healthcare Admission System");
        System.out.println("Available commands:");
        System.out.println("1. admit <name> <dateOfBirth(dd/MM/yyyy)> <contactInfo>");
        System.out.println("2. discharge <residentID>");
        System.out.println("3. list");
        System.out.println("4. beds");
        System.out.println("5. exit");

        while (true) {
            System.out.print("\nEnter command: ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            ParsedInput parsedInput = parser.parse(input);
            if (parsedInput != null) {
                Command command = handler.createCommand(parsedInput);
                if (command != null) {
                    CommandResponse response = command.execute();
                    System.out.println(response.getMessage());
                }
            }
        }
        
        scanner.close();
        System.out.println("System shutting down...");
    }
} 