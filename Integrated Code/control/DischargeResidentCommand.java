package control;

import entity.Resident;
import manager.EquipmentManager;
import manager.ResidentRegistry;
import manager.RoomManager;
import state.DischargedState;

import java.util.Scanner;

public class DischargeResidentCommand implements Command {
    private final Scanner scanner;

    public DischargeResidentCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Discharge Resident ---");
        System.out.print("Enter Resident ID: ");
        String residentId = scanner.nextLine();

        Resident resident = ResidentRegistry.getInstance().getResidentById(residentId);
        if (resident == null) {
            System.out.println("Resident not found.");
            return;
        }

        // Step 1: Update Resident State
        resident.setState(new DischargedState());

        // Step 2: Release Room
        if (resident.getRoomAssigned() != null) {
            String roomNumber = resident.getRoomAssigned().getRoomNumber();
            RoomManager.getInstance().releaseRoom(roomNumber);
            System.out.println("Room " + roomNumber + " released.");
            resident.setRoomAssigned(null);
        }

        // Step 3: Release Equipment
        if (resident.getEquipmentAssigned() != null) {
            String equipmentID = resident.getEquipmentAssigned().getEquipmentID();
            EquipmentManager.getInstance().releaseEquipment(equipmentID);
            System.out.println("Equipment " + equipmentID + " released.");
            resident.setEquipmentAssigned(null);
        }

        // Step 4: Confirmation
        System.out.println("Resident " + residentId + " has been successfully discharged.");
    }
}
