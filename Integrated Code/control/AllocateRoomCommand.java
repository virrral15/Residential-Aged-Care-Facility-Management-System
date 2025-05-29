package control;

import entity.Resident;
import entity.Room;
import manager.ResidentRegistry;
import manager.RoomManager;

import java.util.List;
import java.util.Scanner;

public class AllocateRoomCommand implements Command {
    private final Scanner scanner;

    public AllocateRoomCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.println("--- Allocate Room to New Resident ---");
        System.out.print("Enter Resident ID: ");
        String residentId = scanner.nextLine();

        Resident resident = ResidentRegistry.getInstance().getResidentById(residentId);
        if (resident == null) {
            System.out.println("Resident not found.");
            return;
        }

        List<Room> availableRooms = RoomManager.getInstance().getAvailableRooms();
        if (availableRooms.isEmpty()) {
            System.out.println("No rooms currently available.");
            return;
        }

        System.out.println("Available Rooms:");
        for (Room room : availableRooms) {
            System.out.printf("-> Room No: %s | Type: %s%n", room.getRoomNumber(), room.getRoomType());
        }

        System.out.print("Enter Room Number to allocate: ");
        String roomNumber = scanner.nextLine();

        boolean success = RoomManager.getInstance().allocateRoomToResident(roomNumber, resident);
        if (success) {
            Room allocatedRoom = RoomManager.getInstance().getRoomByNumber(roomNumber);
            resident.setRoomAssigned(allocatedRoom);
            System.out.println("Room " + roomNumber + " successfully allocated to Resident " + residentId);
        } else {
            System.out.println("Allocation failed. Room might be unavailable.");
        }
    }
}
