package facility_resource_management;

import java.util.Scanner;

public class AllocateRoomCommand implements Command {
    private RoomManager roomManager;

    public AllocateRoomCommand() {
        this.roomManager = RoomManager.getInstance(); // Singleton usage
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

        System.out.println("Available Rooms:");
        for (Room r : roomManager.getAvailableRooms()) {
            System.out.println("- Room " + r.getRoomNumber() + " (" + r.getRoomType() + ")");
        }

        System.out.print("Enter Room Number to Allocate: ");
        String roomNumber = scanner.nextLine();

        boolean success = roomManager.allocateRoomToResident(roomNumber, resident);
        if (success) {
            System.out.println("✅ Room " + roomNumber + " successfully allocated to " + resident.getName());
            ResidentRegistry.getInstance().registerResident(resident);
        } else {
            System.out.println("❌ Failed to allocate room. It may not be available.");
        }
    }
}
