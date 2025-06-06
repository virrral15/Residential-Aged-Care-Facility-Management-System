package manager;

import entity.Room;
import entity.Resident;
import state.*;

import java.util.ArrayList;
import java.util.List;

public class RoomManager {
    private static RoomManager instance;
    private List<Room> rooms;

    // Private constructor for Singleton
    private RoomManager() {
        this.rooms = new ArrayList<>();
        // Add mock data
        rooms.add(new Room("101", "Single", new RoomAvailableState()));
        rooms.add(new Room("102", "Double", new RoomAvailableState()));
        rooms.add(new Room("103", "Single", new RoomAvailableState()));
        rooms.add(new Room("104", "Double", new RoomAvailableState()));
        rooms.add(new Room("105", "Single", new RoomAvailableState()));
        rooms.add(new Room("106", "Double", new RoomMaintenanceState()));
        rooms.add(new Room("107", "Single", new RoomAvailableState()));
        rooms.add(new Room("108", "Single", new RoomOccupiedState()));
        rooms.add(new Room("109", "Double", new RoomAvailableState()));
        rooms.add(new Room("110", "Single", new RoomAvailableState()));
    }

    public static RoomManager getInstance() {
        if (instance == null) {
            instance = new RoomManager();
        }
        return instance;
    }

    public boolean allocateRoomToResident(String roomNumber, Resident resident) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && room.getState() instanceof RoomAvailableState) {
                room.setAssignedResident(resident);
                room.setState(new RoomOccupiedState());
                return true;
            }
        }
        return false;
    }

    public boolean releaseRoom(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && room.getState() instanceof RoomOccupiedState) {
                room.setAssignedResident(null);
                room.setState(new RoomAvailableState());
                return true;
            }
        }
        return false;
    }

    public boolean markRoomUnderMaintenance(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                room.setState(new RoomMaintenanceState());
                return true;
            }
        }
        return false;
    }

    public boolean markRoomAsAvailable(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber) && room.getState() instanceof RoomMaintenanceState) {
                room.setState(new RoomAvailableState());
                return true;
            }
        }
        return false;
    }

    public void displayRoomStatus() {
        System.out.printf("%-10s %-10s %-20s%n", "Room No", "Type", "Status");
        System.out.println("----------------------------------------");
        for (Room room : rooms) {
            System.out.printf("%-10s %-10s %-20s%n",
                    room.getRoomNumber(),
                    room.getRoomType(),
                    room.getState().getStatus());
        }
    }

    public List<Room> getAvailableRooms() {
        List<Room> available = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getState() instanceof RoomAvailableState) {
                available.add(room);
            }
        }
        return available;
    }

    public List<Room> getAllRooms() {
        return rooms;
    }

    public Room getRoomByNumber(String roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

}
