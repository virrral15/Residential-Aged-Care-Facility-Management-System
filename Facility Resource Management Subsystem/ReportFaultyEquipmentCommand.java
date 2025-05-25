package FRMS;

import java.util.Scanner;

public class ReportFaultyEquipmentCommand implements Command {
    private EquipmentManager equipmentManager;

    public ReportFaultyEquipmentCommand() {
        this.equipmentManager = EquipmentManager.getInstance();
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Equipment ID to report as faulty: ");
        String equipmentID = scanner.nextLine();

        boolean success = equipmentManager.reportFaultyEquipment(equipmentID);
        if (success) {
            System.out.println("✅ Equipment " + equipmentID + " has been marked as Out of Order.");
        } else {
            System.out.println("❌ Failed to update equipment status. Please check the ID.");
        }
    }
}
