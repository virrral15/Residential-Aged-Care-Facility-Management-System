package entity;

import state.RoomState;

public class Room {
    private String roomNumber;
    private String roomType; // Single or Double
    private RoomState state;
    private Resident assignedResident;

    public Room(String roomNumber, String roomType, RoomState state) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.state = state;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
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
