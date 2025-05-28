package facility_resource_management;

import java.util.Scanner;

public class MarkRoomAvailableCommand implements Command {
    private RoomManager roomManager;

    public MarkRoomAvailableCommand() {
        this.roomManager = RoomManager.getInstance();
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Room Number to mark as Available: ");
        String roomNumber = scanner.nextLine();

        boolean success = roomManager.markRoomAsAvailable(roomNumber);
        if (success) {
            System.out.println("✅ Room " + roomNumber + " is now marked as 'Available'.");
        } else {
            System.out.println("❌ Could not update the room. Ensure it's currently Under Maintenance.");
        }
    }
}
