package admission.entity;

import admission.states.*;
import java.util.Date;
import java.util.UUID;

public class Resident {
    private final String residentID;
    private final String name;
    private final Date dateOfBirth;
    private final String contactInfo;
    private Bed assignedBed;
    private ResidentState state;

    public Resident(String name, Date dateOfBirth, String contactInfo) {
        this.residentID = UUID.randomUUID().toString();
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.contactInfo = contactInfo;
        this.state = DischargedState.getInstance();
    }

    public String getResidentID() {
        return residentID;
    }

    public String getName() {
        return name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void assignBed(Bed bed) {
        this.assignedBed = bed;
        bed.markOccupied(this);
        this.state = AdmittedState.getInstance();
    }

    public void discharge() {
        if (assignedBed != null) {
            assignedBed.markAvailable();
            assignedBed = null;
        }
        this.state = DischargedState.getInstance();
    }

    public Bed getAssignedBed() {
        return assignedBed;
    }

    public boolean isAdmitted() {
        return state.isAdmitted();
    }

    public void setState(ResidentState state) {
        this.state = state;
    }

    public ResidentState getState() {
        return state;
    }
} 