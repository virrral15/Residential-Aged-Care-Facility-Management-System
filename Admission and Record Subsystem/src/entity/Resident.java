package entity;

import java.util.Date;
import java.util.UUID;
import states.ResidentState;
import states.AdmittedState;
import states.DischargedState;

/**
 * Represents a resident in the UnitingSA admission system.
 * Each resident has a unique ID, personal information, and can be assigned to a bed.
 * Uses the State pattern to manage admission status.
 */
public class Resident {
    private final String residentID;
    private final String name;
    private final Date dateOfBirth;
    private final String contact;
    private Bed assignedBed;
    private ResidentState state;

    /**
     * Creates a new resident with the specified details.
     * The resident is automatically assigned an "Admitted" state.
     * 
     * @param name the resident's full name
     * @param dob the resident's date of birth
     * @param contact the resident's contact information
     */
    public Resident(String name, Date dob, String contact) {
        this.residentID = UUID.randomUUID().toString().substring(0, 8);
        this.name = name;
        this.dateOfBirth = dob;
        this.contact = contact;
        this.state = new AdmittedState();
    }

    /**
     * Assigns a bed to this resident and marks the bed as occupied.
     * 
     * @param bed the bed to assign to this resident
     */
    public void assignBed(Bed bed) {
        this.assignedBed = bed;
        bed.markOccupied();
    }

    /**
     * Discharges the resident by changing their state to "Discharged"
     * and freeing up their assigned bed if they have one.
     */
    public void discharge() {
        this.state = new DischargedState();
        if (assignedBed != null) {
            assignedBed.markAvailable();
        }
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

    /**
     * Checks if the resident has been discharged.
     * 
     * @return true if the resident is discharged, false otherwise
     */
    public boolean isDischarged() {
        return state instanceof DischargedState;
    }

    /**
     * Gets the current status of the resident.
     * 
     * @return the status string from the current state
     */
    public String getStatus() {
        return state.getStatus();
    }

    public ResidentState getState() {
        return state;
    }
}
