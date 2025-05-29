package entity;

import state.EquipmentState;

public class Equipment {
    private String equipmentID;
    private String equipmentType;
    private EquipmentState state;
    private Resident assignedResident;

    public Equipment(String equipmentID, String equipmentType, EquipmentState state) {
        this.equipmentID = equipmentID;
        this.equipmentType = equipmentType;
        this.state = state;
    }

    public String getEquipmentID() {
        return equipmentID;
    }

    public String getEquipmentType() {
        return equipmentType;
    }

    public EquipmentState getState() {
        return state;
    }

    public void setState(EquipmentState state) {
        this.state = state;
    }

    public Resident getAssignedResident() {
        return assignedResident;
    }

    public void setAssignedResident(Resident assignedResident) {
        this.assignedResident = assignedResident;
    }
}
