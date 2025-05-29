package manager;

import entity.Resident;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class ResidentRegistry {
    private static ResidentRegistry instance;
    private Map<String, Resident> residentMap;

    private ResidentRegistry() {
        residentMap = new HashMap<>();
    }

    public static ResidentRegistry getInstance() {
        if (instance == null) {
            instance = new ResidentRegistry();
        }
        return instance;
    }

    public void addResident(Resident resident) {
        residentMap.put(resident.getResidentId(), resident);
    }

    public Resident getResidentById(String residentId) {
        return residentMap.get(residentId);
    }

    public boolean dischargeResident(String residentId) {
        Resident res = residentMap.get(residentId);
        if (res != null) {
            res.setState(new state.DischargedState());
            return true;
        }
        return false;
    }

    public Collection<Resident> getAllResidents() {
        return residentMap.values();
    }

    public Collection<Resident> getAdmittedResidents() {
        return residentMap.values().stream()
            .filter(r -> r.getState().getStatus().equalsIgnoreCase("Admitted"))
            .toList();
    }
}
