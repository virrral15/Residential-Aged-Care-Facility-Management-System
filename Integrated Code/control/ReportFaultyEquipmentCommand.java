package control;

import manager.EquipmentManager;

import java.util.Scanner;

public class ReportFaultyEquipmentCommand implements Command {
    private final Scanner scanner;

    public ReportFaultyEquipmentCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Report Faulty Equipment ---");
        System.out.print("Enter Equipment ID: ");
        String equipmentID = scanner.nextLine();

        boolean success = EquipmentManager.getInstance().reportFaultyEquipment(equipmentID);
        if (success) {
            System.out.println("Equipment " + equipmentID + " marked as Out of Order.");
        } else {
            System.out.println("Equipment ID not found.");
        }
    }
}
