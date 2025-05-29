package manager;

public class ScheduleEntry {
    private String staffName;
    private String day;
    private String shiftTime; // e.g., "Morning", "Evening"

    public ScheduleEntry(String staffName, String day, String shiftTime) {
        this.staffName = staffName;
        this.day = day;
        this.shiftTime = shiftTime;
    }

    public String getStaffName() {
        return staffName;
    }

    public String getDay() {
        return day;
    }

    public String getShiftTime() {
        return shiftTime;
    }

    @Override
    public String toString() {
        return day + " - " + shiftTime + " Shift | Staff: " + staffName;
    }
}
