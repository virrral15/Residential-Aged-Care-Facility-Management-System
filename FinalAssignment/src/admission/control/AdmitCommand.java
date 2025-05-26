package admission.control;

import admission.manager.AdmissionManager;
import admission.entity.Resident;
import java.util.Date;

public class AdmitCommand implements Command {
    private final String name;
    private final Date dateOfBirth;
    private final String contactInfo;

    public AdmitCommand(String name, Date dateOfBirth, String contactInfo) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactInfo = contactInfo;
    }

    @Override
    public CommandResponse execute() {
        try {
            Resident resident = AdmissionManager.getInstance().admitResident(name, dateOfBirth, contactInfo);
            return new CommandResponse(true, "Successfully admitted resident: " + resident.getName() + 
                                          "\nAssigned to bed: " + resident.getAssignedBed().getBedID());
        } catch (RuntimeException e) {
            return new CommandResponse(false, "Failed to admit resident: " + e.getMessage());
        }
    }
} 