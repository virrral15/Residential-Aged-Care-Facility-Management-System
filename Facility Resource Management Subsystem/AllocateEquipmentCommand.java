package FRMS;

import java.util.Scanner;

public class AllocateEquipmentCommand implements Command {
    private EquipmentManager equipmentManager;

    public AllocateEquipmentCommand() {
        this.equipmentManager = EquipmentManager.getInstance();
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Resident ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter Resident Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Admission Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        Resident resident = new Resident(id, name, date);

        System.out.print("Enter Equipment Type to Search (e.g., Wheelchair): ");
        String type = scanner.nextLine();

        var available = equipmentManager.getAvailableByType(type);

        if (available.isEmpty()) {
            System.out.println("⚠️ No available equipment of this type.");
            return;
        }

        System.out.println("Available Equipment:");
        for (Equipment e : available) {
            System.out.println("- " + e.getEquipmentID() + " (" + e.getEquipmentType() + ")");
        }

        System.out.print("Enter Equipment ID to Assign: ");
        String equipmentID = scanner.nextLine();

        boolean success = equipmentManager.assignEquipment(equipmentID, resident);
        if (success) {
            System.out.println("✅ Equipment " + equipmentID + " assigned to " + resident.getName());
        } else {
            System.out.println("❌ Failed to assign equipment. It may be unavailable.");
        }
    }
}
