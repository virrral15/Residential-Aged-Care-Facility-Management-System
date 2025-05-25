package facility_resource_management;

import java.util.Scanner;

public class CreateRosterCommand implements Command {
    private RosterManager rosterManager;

    public CreateRosterCommand(RosterManager rosterManager) {
        this.rosterManager = rosterManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roster ID: ");
        String rosterID = scanner.nextLine();

        System.out.print("Enter Week Start Date (YYYY-MM-DD): ");
        String weekStart = scanner.nextLine();

        boolean success = rosterManager.createRoster(rosterID, weekStart);
        if (success) {
            System.out.println("✅ Roster created successfully.");
        } else {
            System.out.println("❌ Roster ID already exists.");
        }
    }
}
