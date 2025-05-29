package control;

import manager.RosterManager;

import java.util.Scanner;

public class ViewRosterCommand implements Command {
    private final Scanner scanner;

    public ViewRosterCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- View Roster ---");
        System.out.print("Enter Week Number: ");
        int week = Integer.parseInt(scanner.nextLine());

        RosterManager.getInstance().viewRoster(week);
    }
}
