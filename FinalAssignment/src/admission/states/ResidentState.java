package admission.states;

import admission.entity.Resident;

public interface ResidentState {
    void handleAdmission(Resident resident);
    void handleDischarge(Resident resident);
    boolean isAdmitted();
} 