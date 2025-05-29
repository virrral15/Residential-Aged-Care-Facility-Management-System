package control;

import manager.RoomManager;

import java.util.Scanner;

public class MarkRoomUnderMaintenanceCommand implements Command {
    private final Scanner scanner;

    public MarkRoomUnderMaintenanceCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("--- Mark Room as Under Maintenance ---\nEnter Room Number: ");
        String roomNumber = scanner.nextLine();

        boolean success = RoomManager.getInstance().markRoomUnderMaintenance(roomNumber);
        if (success)
            System.out.println("Room " + roomNumber + " marked under maintenance.");
        else
            System.out.println("Room ID not found.");
    }
}
