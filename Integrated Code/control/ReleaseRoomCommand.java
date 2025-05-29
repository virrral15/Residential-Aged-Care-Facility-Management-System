package control;

import entity.Resident;
import entity.Room;
import manager.ResidentRegistry;
import manager.RoomManager;

import java.util.Scanner;

public class ReleaseRoomCommand implements Command {
    private final Scanner scanner;

    public ReleaseRoomCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Release Room After Discharge ---");
        System.out.print("Enter Resident ID: ");
        String residentId = scanner.nextLine();

        Resident resident = ResidentRegistry.getInstance().getResidentById(residentId);
        Room room = resident != null ? resident.getRoomAssigned() : null;

        if (resident == null || room == null) {
            System.out.println("Resident not found or no room is currently assigned.");
            return;
        }

        boolean success = RoomManager.getInstance().releaseRoom(room.getRoomNumber());
        if (success) {
            resident.setRoomAssigned(null);
            System.out.println("Room " + room.getRoomNumber() + " has been released.");
        } else {
            System.out.println("Failed to release room.");
        }
    }
}
