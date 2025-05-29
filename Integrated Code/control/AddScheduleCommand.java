package control;

import manager.RosterManager;
import manager.ScheduleEntry;

import java.util.Scanner;

public class AddScheduleCommand implements Command {
    private final Scanner scanner;

    public AddScheduleCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Add Schedule to Roster ---");
        System.out.print("Enter Week Number: ");
        int week = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Day (e.g., Monday): ");
        String day = scanner.nextLine();

        System.out.print("Enter Shift (e.g., Morning, Evening): ");
        String shift = scanner.nextLine();

        ScheduleEntry entry = new ScheduleEntry(name, day, shift);
        RosterManager.getInstance().addScheduleToWeek(week, entry);
    }
}
