package FRMS;

import java.util.Scanner;

public class UpdateShiftCommand implements Command {
    private RosterManager rosterManager;

    public UpdateShiftCommand(RosterManager rosterManager) {
        this.rosterManager = rosterManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roster ID: ");
        String rosterID = scanner.nextLine();

        System.out.print("Enter Staff ID to Update: ");
        String staffID = scanner.nextLine();

        System.out.print("Enter New Shift Date: ");
        String newDate = scanner.nextLine();

        System.out.print("Enter New Shift Time: ");
        String newTime = scanner.nextLine();

        boolean updated = rosterManager.updateShift(rosterID, staffID, newDate, newTime);
        if (updated) {
            System.out.println("✅ Shift updated successfully.");
        } else {
            System.out.println("❌ Update failed. Check roster and staff ID.");
        }
    }
}
