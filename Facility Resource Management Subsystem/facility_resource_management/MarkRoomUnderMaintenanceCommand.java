package facility_resource_management;

import java.util.Scanner;

public class MarkRoomUnderMaintenanceCommand implements Command {
    private RoomManager roomManager;

    public MarkRoomUnderMaintenanceCommand() {
        this.roomManager = RoomManager.getInstance();
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Room Number to mark as Under Maintenance: ");
        String roomNumber = scanner.nextLine();

        boolean success = roomManager.markRoomUnderMaintenance(roomNumber);
        if (success) {
            System.out.println("✅ Room " + roomNumber + " is now marked as 'Under Maintenance'.");
        } else {
            System.out.println("❌ Could not update the room. Please check if the room number exists.");
        }
    }
}
