package manager;

import java.util.*;

public class RosterManager {
    private static RosterManager instance;

    // Map<WeekNumber, List<ScheduleEntry>>
    private Map<Integer, List<ScheduleEntry>> rosterMap;

    private RosterManager() {
        rosterMap = new HashMap<>();
    }

    public static RosterManager getInstance() {
        if (instance == null) {
            instance = new RosterManager();
        }
        return instance;
    }

    public void createRosterForWeek(int weekNumber) {
        if (!rosterMap.containsKey(weekNumber)) {
            rosterMap.put(weekNumber, new ArrayList<>());
            System.out.println(" Roster created for Week " + weekNumber);
        } else {
            System.out.println("Roster already exists for Week " + weekNumber);
        }
    }

    public void addScheduleToWeek(int weekNumber, ScheduleEntry entry) {
        if (!rosterMap.containsKey(weekNumber)) {
            System.out.println("Roster does not exist for Week " + weekNumber + ". Please create it first.");
            return;
        }
        rosterMap.get(weekNumber).add(entry);
        System.out.println("Schedule added to Week " + weekNumber);
    }

    public boolean updateShift(int weekNumber, int index, ScheduleEntry updatedEntry) {
        if (rosterMap.containsKey(weekNumber)) {
            List<ScheduleEntry> list = rosterMap.get(weekNumber);
            if (index >= 0 && index < list.size()) {
                list.set(index, updatedEntry);
                return true;
            }
        }
        return false;
    }

    public void viewRoster(int weekNumber) {
        if (rosterMap.containsKey(weekNumber)) {
            List<ScheduleEntry> entries = rosterMap.get(weekNumber);
            System.out.println("Roster for Week " + weekNumber + ":");
            for (int i = 0; i < entries.size(); i++) {
                System.out.println((i + 1) + ". " + entries.get(i));
            }
        } else {
            System.out.println("No roster found for Week " + weekNumber);
        }
    }
}
