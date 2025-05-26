package admission.states;

import admission.entity.Resident;

public class DischargedState implements ResidentState {
    private static DischargedState instance;
    
    private DischargedState() {}
    
    public static DischargedState getInstance() {
        if (instance == null) {
            instance = new DischargedState();
        }
        return instance;
    }

    @Override
    public void handleAdmission(Resident resident) {
        // Logic for readmission would go here
    }

    @Override
    public void handleDischarge(Resident resident) {
        // Already discharged, no action needed
    }

    @Override
    public boolean isAdmitted() {
        return false;
    }
} 