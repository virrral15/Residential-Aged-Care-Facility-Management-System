package FRMS;

public class Schedule {
    private String shiftDate;
    private String shiftTime;
    private Staff assignedStaff;

    public Schedule(String shiftDate, String shiftTime, Staff assignedStaff) {
        this.shiftDate = shiftDate;
        this.shiftTime = shiftTime;
        this.assignedStaff = assignedStaff;
    }

    // Getters and Setters
    public String getShiftDate() {
        return shiftDate;
    }

    public void setShiftDate(String shiftDate) {
        this.shiftDate = shiftDate;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    public void setShiftTime(String shiftTime) {
        this.shiftTime = shiftTime;
    }

    public Staff getAssignedStaff() {
        return assignedStaff;
    }

    public void setAssignedStaff(Staff assignedStaff) {
        this.assignedStaff = assignedStaff;
    }
}
