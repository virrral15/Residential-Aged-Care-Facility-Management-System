package admission.entity;

public class Bed {
    private final String bedID;
    private boolean isAvailable;
    private Resident resident;

    public Bed(String bedID) {
        this.bedID = bedID;
        this.isAvailable = true;
    }

    public String getBedID() {
        return bedID;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void markAvailable() {
        this.isAvailable = true;
        this.resident = null;
    }

    public void markOccupied(Resident resident) {
        this.isAvailable = false;
        this.resident = resident;
    }

    public Resident getResident() {
        return resident;
    }
} 