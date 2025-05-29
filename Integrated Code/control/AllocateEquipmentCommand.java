package control;

import entity.Equipment;
import entity.Resident;
import manager.EquipmentManager;
import manager.ResidentRegistry;

import java.util.List;
import java.util.Scanner;

public class AllocateEquipmentCommand implements Command {
    private final Scanner scanner;

    public AllocateEquipmentCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Allocate Equipment to Resident ---");
        System.out.print("Enter Resident ID: ");
        String residentId = scanner.nextLine();

        Resident resident = ResidentRegistry.getInstance().getResidentById(residentId);
        if (resident == null) {
            System.out.println("Resident not found.");
            return;
        }

        System.out.print("Enter Equipment Type (e.g., Wheelchair, IV Pump): ");
        String type = scanner.nextLine();

        List<Equipment> available = EquipmentManager.getInstance().getAvailableByType(type);
        if (available.isEmpty()) {
            System.out.println("No available equipment of type: " + type);
            return;
        }

        System.out.println("Available Equipment:");
        for (Equipment eq : available) {
            System.out.printf("-> ID: %s | Type: %s%n", eq.getEquipmentID(), eq.getEquipmentType());
        }

        System.out.print("Enter Equipment ID to allocate: ");
        String equipmentID = scanner.nextLine();

        boolean success = EquipmentManager.getInstance().assignEquipment(equipmentID, resident);
        if (success) {
            Equipment eq = EquipmentManager.getInstance().getEquipmentById(equipmentID);
            resident.setEquipmentAssigned(eq);
            System.out.println("Equipment " + equipmentID + " allocated to Resident " + residentId);
        } else {
            System.out.println("Allocation failed. Equipment might not be available.");
        }
    }
}
