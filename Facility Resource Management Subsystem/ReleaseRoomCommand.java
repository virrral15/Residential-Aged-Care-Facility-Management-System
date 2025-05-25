package FRMS;

import java.util.Scanner;

public class ReleaseRoomCommand implements Command {
    private RoomManager roomManager;

    public ReleaseRoomCommand() {
        this.roomManager = RoomManager.getInstance();
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Room Number to Release: ");
        String roomNumber = scanner.nextLine();

        boolean success = roomManager.releaseRoom(roomNumber);
        if (success) {
            System.out.println("✅ Room " + roomNumber + " has been released and marked as Available.");
        } else {
            System.out.println("❌ Failed to release room. It may already be available or invalid.");
        }
    }
}
