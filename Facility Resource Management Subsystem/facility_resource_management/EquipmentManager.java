package facility_resource_management;

import java.util.*;

public class EquipmentManager {
    private static EquipmentManager instance;
    private List<Equipment> equipmentList;

    // Private constructor for Singleton
    private EquipmentManager() {
        this.equipmentList = new ArrayList<>();
        // Add sample equipment
        equipmentList.add(new Equipment("EQ001", "Wheelchair", new EquipmentAvailableState()));
        equipmentList.add(new Equipment("EQ002", "Heart Monitor", new EquipmentAvailableState()));
        equipmentList.add(new Equipment("EQ003", "IV Pump", new EquipmentAvailableState()));
        equipmentList.add(new Equipment("EQ004", "Oxygen Tank", new EquipmentInUseState()));
        equipmentList.add(new Equipment("EQ005", "Bedside Commode", new EquipmentAvailableState()));
        equipmentList.add(new Equipment("EQ006", "Hospital Bed", new EquipmentOutOfOrderState()));
        equipmentList.add(new Equipment("EQ007", "Walker", new EquipmentAvailableState()));
        equipmentList.add(new Equipment("EQ008", "Defibrillator", new EquipmentAvailableState()));
        equipmentList.add(new Equipment("EQ009", "Infusion Pump", new EquipmentAvailableState()));
        equipmentList.add(new Equipment("EQ010", "Pulse Oximeter", new EquipmentAvailableState()));
    }

    // Singleton instance
    public static EquipmentManager getInstance() {
        if (instance == null) {
            instance = new EquipmentManager();
        }
        return instance;
    }

    // Assign equipment to resident
    public boolean assignEquipment(String equipmentID, Resident resident) {
        for (Equipment e : equipmentList) {
            if (e.getEquipmentID().equals(equipmentID) && e.getState() instanceof EquipmentAvailableState) {
                e.setAssignedResident(resident);
                e.setState(new EquipmentInUseState());
                return true;
            }
        }
        return false;
    }

    // Release equipment after discharge
    public boolean releaseEquipment(String equipmentID) {
        for (Equipment e : equipmentList) {
            if (e.getEquipmentID().equals(equipmentID) && e.getState() instanceof EquipmentInUseState) {
                e.setAssignedResident(null);
                e.setState(new EquipmentAvailableState());
                return true;
            }
        }
        return false;
    }

    // Mark equipment as out of order
    public boolean reportFaultyEquipment(String equipmentID) {
        for (Equipment e : equipmentList) {
            if (e.getEquipmentID().equals(equipmentID)) {
                e.setState(new EquipmentOutOfOrderState());
                return true;
            }
        }
        return false;
    }

    // Monitor status of all equipment
    public void displayEquipmentStatus() {
        System.out.printf("%-10s %-15s %-20s%n", "Equip ID", "Type", "Status");
        System.out.println("---------------------------------------------");
        for (Equipment e : equipmentList) {
            System.out.printf("%-10s %-15s %-20s%n", e.getEquipmentID(), e.getEquipmentType(), e.getState().getStatus());
        }
    }

    // Return all available equipment of a given type
    public List<Equipment> getAvailableByType(String type) {
        List<Equipment> available = new ArrayList<>();
        for (Equipment e : equipmentList) {
            if (e.getEquipmentType().equalsIgnoreCase(type) && e.getState() instanceof EquipmentAvailableState) {
                available.add(e);
            }
        }
        return available;
    }
}
