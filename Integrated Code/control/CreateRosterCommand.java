package control;

import manager.RosterManager;

import java.util.Scanner;

public class CreateRosterCommand implements Command {
    private final Scanner scanner;

    public CreateRosterCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("--- Create Weekly Roster ---\nEnter Week Number (e.g., 23): ");
        int week = Integer.parseInt(scanner.nextLine());
        RosterManager.getInstance().createRosterForWeek(week);
    }
}
