package FRMS;

import java.util.Scanner;

public class DisplayRosterCommand implements Command {
    private RosterManager rosterManager;

    public DisplayRosterCommand(RosterManager rosterManager) {
        this.rosterManager = rosterManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Roster ID to Display: ");
        String rosterID = scanner.nextLine();
        rosterManager.displayRoster(rosterID);
    }
}
