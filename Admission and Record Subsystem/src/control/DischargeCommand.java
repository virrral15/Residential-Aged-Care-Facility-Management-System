package control;

import manager.AdmissionManager;

public class DischargeCommand implements Command {
    @Override
    public CommandResponse execute(AdmissionManager manager, String[] args) {
        if (args.length == 0) {
            return new CommandResponse("Error: Please provide a resident ID", false);
        }
        
        boolean success = manager.dischargeResident(args[0]);
        return new CommandResponse(
            success ? "Discharge successful" : "Resident not found",
            success
        );
    }
}
