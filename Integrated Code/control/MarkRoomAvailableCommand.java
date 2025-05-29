package control;

import manager.RoomManager;

import java.util.Scanner;

public class MarkRoomAvailableCommand implements Command {
    private final Scanner scanner;

    public MarkRoomAvailableCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        System.out.print("--- Mark Room as Available ---\nEnter Room Number: ");
        String roomNumber = scanner.nextLine();

        boolean success = RoomManager.getInstance().markRoomAsAvailable(roomNumber);
        if (success)
            System.out.println("Room " + roomNumber + " is now available.");
        else
            System.out.println("Room is not in maintenance or doesn't exist.");
    }
}
