package admission.manager;

import admission.entity.*;
import java.util.*;

public class AdmissionManager {
    private static AdmissionManager instance;
    private final List<Resident> residents = new ArrayList<>();
    private final List<Bed> beds = Arrays.asList(
        new Bed("B101"), new Bed("B102"), new Bed("B103")
    );

    private AdmissionManager() {}

    public static AdmissionManager getInstance() {
        if (instance == null) instance = new AdmissionManager();
        return instance;
    }

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

    public boolean dischargeResident(String residentID) {
        Optional<Resident> resident = residents.stream()
            .filter(r -> r.getResidentID().equals(residentID))
            .findFirst();
        
        resident.ifPresent(r -> {
            r.discharge();
            r.getAssignedBed().markAvailable();
        });
        return resident.isPresent();
    }

    public List<Bed> getAvailableBeds() {
        return beds.stream().filter(Bed::isAvailable).toList();
    }

    public List<Resident> getResidents() {
        return new ArrayList<>(residents);
    }

    public String getBedStatus() {
        StringBuilder sb = new StringBuilder("\n--- Bed Status ---\n");
        beds.forEach(b -> sb.append(b.getBedID())
            .append(": ")
            .append(b.isAvailable() ? "Available" : "Occupied")
            .append("\n"));
        return sb.toString();
    }
} 