package manager;

import entity.*;
import java.util.*;

/**
 * Manages the admission system for UnitingSA.
 * Handles resident admissions, discharges, and bed management.
 * Implements the Singleton pattern to ensure only one instance exists.
 */
public class AdmissionManager {
    private static AdmissionManager instance;
    private final List<Resident> residents = new ArrayList<>();
    private final List<Bed> beds = Arrays.asList(
        new Bed("B101"), new Bed("B102"), new Bed("B103")
    );

    private AdmissionManager() {}

    /**
     * Gets the singleton instance of AdmissionManager.
     * 
     * @return the single instance of AdmissionManager
     */
    public static AdmissionManager getInstance() {
        if (instance == null) instance = new AdmissionManager();
        return instance;
    }

    /**
     * Admits a new resident to the facility.
     * Automatically assigns an available bed to the resident.
     * 
     * @param name the resident's name
     * @param dob the resident's date of birth
     * @param contact the resident's contact information
     * @return the newly created and admitted resident
     * @throws RuntimeException if no beds are available
     */
    public Resident admitResident(String name, Date dob, String contact) {
        Bed availableBed = beds.stream()
            .filter(Bed::isAvailable)
            .findFirst()
            .orElseThrow(() -> new RuntimeException("No beds available"));
        
        Resident resident = new Resident(name, dob, contact);
        resident.assignBed(availableBed);
        residents.add(resident);
        return resident;
    }

    /**
     * Discharges a resident from the facility.
     * 
     * @param residentID the ID of the resident to discharge
     * @return true if the resident was found and discharged, false otherwise
     */
    public boolean dischargeResident(String residentID) {
        Optional<Resident> resident = residents.stream()
            .filter(r -> r.getResidentID().equals(residentID))
            .findFirst();
        
        resident.ifPresent(Resident::discharge);
        return resident.isPresent();
    }

    /**
     * Gets a list of all available beds.
     * 
     * @return a list of available beds
     */
    public List<Bed> getAvailableBeds() {
        return beds.stream().filter(Bed::isAvailable).toList();
    }

    /**
     * Gets a defensive copy of all residents.
     * 
     * @return a new list containing all residents
     */
    public List<Resident> getResidents() {
        return new ArrayList<>(residents);
    }

    /**
     * Gets a formatted string showing the status of all beds.
     * 
     * @return a formatted string with bed status information
     */
    public String getBedStatus() {
        StringBuilder sb = new StringBuilder("\n--- Bed Status ---\n");
        beds.forEach(b -> sb.append(b.getBedID())
            .append(": ")
            .append(b.isAvailable() ? "Available" : "Occupied")
            .append("\n"));
        return sb.toString();
    }
}