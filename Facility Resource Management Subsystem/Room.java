package FRMS;

public class Room {
    private String roomNumber;
    private String roomType;
    private RoomState state; // Follows State pattern
    private Resident assignedResident;

    public Room(String roomNumber, String roomType, RoomState state) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.state = state;
        this.assignedResident = null;
    }

    // Getters and Setters
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public RoomState getState() {
        return state;
    }

    public void setState(RoomState state) {
        this.state = state;
    }

    public Resident getAssignedResident() {
        return assignedResident;
    }

    public void setAssignedResident(Resident assignedResident) {
        this.assignedResident = assignedResident;
    }
}
