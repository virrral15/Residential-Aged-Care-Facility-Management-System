package control;

import manager.RosterManager;
import manager.ScheduleEntry;

import java.util.Scanner;

public class UpdateShiftCommand implements Command {
    private final Scanner scanner;

    public UpdateShiftCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Update Shift Assignment ---");
        System.out.print("Enter Week Number: ");
        int week = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Entry Number to Update (starts from 1): ");
        int index = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Enter New Staff Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter New Day: ");
        String day = scanner.nextLine();

        System.out.print("Enter New Shift Time: ");
        String shift = scanner.nextLine();

        ScheduleEntry updated = new ScheduleEntry(name, day, shift);
        boolean result = RosterManager.getInstance().updateShift(week, index, updated);
        if (result)
            System.out.println("Shift updated successfully.");
        else
            System.out.println("Invalid week or entry index.");
    }
}
