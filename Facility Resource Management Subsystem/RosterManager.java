package FRMS;

import java.util.ArrayList;
import java.util.List;

public class RosterManager {
    private List<Roster> rosters;

    public RosterManager() {
        this.rosters = new ArrayList<>();
    }

    // Create a new roster for a given week
    public boolean createRoster(String rosterID, String weekStartDate) {
        for (Roster r : rosters) {
            if (r.getRosterID().equals(rosterID)) {
                return false; // Roster ID already exists
            }
        }
        Roster newRoster = new Roster(rosterID, weekStartDate);
        rosters.add(newRoster);
        return true;
    }

    // Add schedule to a specific roster
    public boolean addScheduleToRoster(String rosterID, Schedule schedule) {
        for (Roster r : rosters) {
            if (r.getRosterID().equals(rosterID)) {
                r.addSchedule(schedule);
                return true;
            }
        }
        return false; // Roster not found
    }

    // Update shift time for a staff member in a specific roster
    public boolean updateShift(String rosterID, String staffID, String newDate, String newTime) {
        for (Roster r : rosters) {
            if (r.getRosterID().equals(rosterID)) {
                for (Schedule s : r.getSchedules()) {
                    if (s.getAssignedStaff().getStaffID().equals(staffID)) {
                        s.setShiftDate(newDate);
                        s.setShiftTime(newTime);
                        return true;
                    }
                }
            }
        }
        return false; // Staff or roster not found
    }

    // Display full roster
    public void displayRoster(String rosterID) {
        for (Roster r : rosters) {
            if (r.getRosterID().equals(rosterID)) {
                r.displayRoster();
                return;
            }
        }
        System.out.println("Roster with ID " + rosterID + " not found.");
    }

    // Get list of all rosters
    public List<Roster> getAllRosters() {
        return rosters;
    }
}
