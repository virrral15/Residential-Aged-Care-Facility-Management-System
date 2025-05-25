package facility_resource_management;

public class Resident {
    private String residentID;
    private String name;
    private String admissionDate;

    public Resident(String residentID, String name, String admissionDate) {
        this.residentID = residentID;
        this.name = name;
        this.admissionDate = admissionDate;
    }

    // Getters and Setters
    public String getResidentID() {
        return residentID;
    }

    public void setResidentID(String residentID) {
        this.residentID = residentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    @Override
    public String toString() {
        return name + " (ID: " + residentID + ")";
    }
}
