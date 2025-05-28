package control;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Resident;
import manager.AdmissionManager;

public class ListResidentsCommand implements Command {
    @Override
    public CommandResponse execute(AdmissionManager manager, String[] args) {
        StringBuilder output = new StringBuilder("\n--- Current Residents ---\n");

        List<Resident> currentResidents = manager.getResidents().stream()
            .filter(r -> !r.isDischarged())
            .toList();

        if (currentResidents.isEmpty()) {
            output.append("No residents found.");
        } else {
            for (Resident r : currentResidents) {
                output.append("ID: ").append(r.getResidentID())
                      .append(" | Name: ").append(r.getName())
                      .append(" | DOB: ").append(new SimpleDateFormat("dd/MM/yyyy").format(r.getDateOfBirth()))
                      .append(" | Contact: ").append(r.getContact())
                      .append(" | Status: ").append(r.getStatus())
                      .append(" | Bed: ").append(r.getAssignedBed() != null ? r.getAssignedBed().getBedID() : "None")
                      .append("\n");
            }
        }

        return new CommandResponse(output.toString(), true);
    }
}