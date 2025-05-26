package facility_resource_management;

import java.util.HashMap;
import java.util.Map;

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

    public void registerResident(Resident resident) {
        residentMap.put(resident.getResidentID(), resident);
    }

    public Resident getResidentById(String id) {
        return residentMap.get(id);
    }

    public boolean residentExists(String id) {
        return residentMap.containsKey(id);
    }
}
