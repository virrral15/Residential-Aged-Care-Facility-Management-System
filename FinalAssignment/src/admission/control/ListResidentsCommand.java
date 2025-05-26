package admission.control;

import admission.manager.AdmissionManager;
import admission.entity.Resident;

public class ListResidentsCommand implements Command {
    @Override
    public CommandResponse execute() {
        StringBuilder sb = new StringBuilder("\n--- Current Residents ---\n");
        for (Resident resident : AdmissionManager.getInstance().getResidents()) {
            sb.append("ID: ").append(resident.getResidentID())
              .append(", Name: ").append(resident.getName())
              .append(", Bed: ").append(resident.getAssignedBed().getBedID())
              .append("\n");
        }
        return new CommandResponse(true, sb.toString());
    }
} 