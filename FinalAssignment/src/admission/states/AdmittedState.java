package admission.states;

import admission.entity.Resident;

public class AdmittedState implements ResidentState {
    private static AdmittedState instance;
    
    private AdmittedState() {}
    
    public static AdmittedState getInstance() {
        if (instance == null) {
            instance = new AdmittedState();
        }
        return instance;
    }

    @Override
    public void handleAdmission(Resident resident) {
        // Already admitted, no action needed
    }

    @Override
    public void handleDischarge(Resident resident) {
        resident.discharge();
    }

    @Override
    public boolean isAdmitted() {
        return true;
    }
} 