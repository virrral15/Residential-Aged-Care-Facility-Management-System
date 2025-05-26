package admission.control;

import admission.manager.AdmissionManager;

public class DischargeCommand implements Command {
    private final String residentID;

    public DischargeCommand(String residentID) {
        this.residentID = residentID;
    }

    @Override
    public CommandResponse execute() {
        boolean success = AdmissionManager.getInstance().dischargeResident(residentID);
        if (success) {
            return new CommandResponse(true, "Successfully discharged resident with ID: " + residentID);
        } else {
            return new CommandResponse(false, "Failed to discharge resident. Resident ID not found: " + residentID);
        }
    }
} 