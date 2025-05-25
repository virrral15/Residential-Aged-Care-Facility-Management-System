package FRMS;

import java.util.ArrayList;
import java.util.List;

public class Roster {
    private String rosterID;
    private String weekStartDate;
    private List<Schedule> schedules;

    public Roster(String rosterID, String weekStartDate) {
        this.rosterID = rosterID;
        this.weekStartDate = weekStartDate;
        this.schedules = new ArrayList<>();
    }

    // Getters and Setters
    public String getRosterID() {
        return rosterID;
    }

    public void setRosterID(String rosterID) {
        this.rosterID = rosterID;
    }

    public String getWeekStartDate() {
        return weekStartDate;
    }

    public void setWeekStartDate(String weekStartDate) {
        this.weekStartDate = weekStartDate;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }

    public void addSchedule(Schedule schedule) {
        this.schedules.add(schedule);
    }

    public void displayRoster() {
        System.out.println("Roster for Week Starting: " + weekStartDate);
        System.out.printf("%-15s %-15s %-20s%n", "Staff ID", "Shift Date", "Shift Time");
        System.out.println("-----------------------------------------------------");
        for (Schedule s : schedules) {
            System.out.printf("%-15s %-15s %-20s%n",
                s.getAssignedStaff().getStaffID(),
                s.getShiftDate(),
                s.getShiftTime()
            );
        }
    }
}
