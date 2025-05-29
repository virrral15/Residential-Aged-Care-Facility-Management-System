package entity;

import state.ResidentState;

public class Resident {
    private String residentId;
    private String name;
    private int age;
    private String contactNumber;
    private String emergencyContact;
    private ResidentState state;

    private Room roomAssigned;
    private Equipment equipmentAssigned;

    public Resident(String residentId, String name, int age, String contactNumber, String emergencyContact, ResidentState state) {
        this.residentId = residentId;
        this.name = name;
        this.age = age;
        this.contactNumber = contactNumber;
        this.emergencyContact = emergencyContact;
        this.state = state;
    }

    // Getters and Setters
    public String getResidentId() {
        return residentId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public ResidentState getState() {
        return state;
    }

    public void setState(ResidentState state) {
        this.state = state;
    }

    public Room getRoomAssigned() {
        return roomAssigned;
    }

    public void setRoomAssigned(Room roomAssigned) {
        this.roomAssigned = roomAssigned;
    }

    public Equipment getEquipmentAssigned() {
        return equipmentAssigned;
    }

    public void setEquipmentAssigned(Equipment equipmentAssigned) {
        this.equipmentAssigned = equipmentAssigned;
    }

    @Override
    public String toString() {
        return "Resident ID: " + residentId + ", Name: " + name +
                ", Age: " + age + ", Contact: " + contactNumber +
                ", Emergency: " + emergencyContact +
                ", State: " + state.getStatus() +
                ", Room: " + (roomAssigned != null ? roomAssigned.getRoomNumber() : "None") +
                ", Equipment: " + (equipmentAssigned != null ? equipmentAssigned.getEquipmentID() : "None");
    }
}
