package FRMS;

public abstract class Staff {
    private String staffID;
    private String name;
    private String role;

    public Staff(String staffID, String name, String role) {
        this.staffID = staffID;
        this.name = name;
        this.role = role;
    }

    // Getters and Setters
    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Abstract method
    public abstract void performDuties();
}
