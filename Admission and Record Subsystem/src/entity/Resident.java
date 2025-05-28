package entity;

import java.util.Date;
import java.util.UUID;

public class Resident {
    private final String residentID;
    private final String name;
    private final Date dateOfBirth;
    private final String contact;
    private Bed assignedBed;
    private boolean discharged;

    public Resident(String name, Date dob, String contact) {
        this.residentID = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.dateOfBirth = dob;
        this.contact = contact;
        this.discharged = false;
    }

    public void assignBed(Bed bed) {
        this.assignedBed = bed;
        bed.markOccupied();
    }

    public void discharge() {
        this.discharged = true;
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

    public String getContact() {
        return contact;
    }

    public Bed getAssignedBed() {
        return assignedBed;
    }

    public boolean isDischarged() {
        return discharged;
    }
}
