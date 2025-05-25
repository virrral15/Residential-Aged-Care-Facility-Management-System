package FRMS;

import java.util.Scanner;

public class AddScheduleToRosterCommand implements Command {
    private RosterManager rosterManager;

    public AddScheduleToRosterCommand(RosterManager rosterManager) {
        this.rosterManager = rosterManager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roster ID: ");
        String rosterID = scanner.nextLine();

        System.out.print("Enter Staff ID: ");
        String staffID = scanner.nextLine();

        System.out.print("Enter Staff Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Role (Admin, Nurse, Maintenance, Supervisor): ");
        String role = scanner.nextLine();

        Staff staff;
        switch (role.toLowerCase()) {
            case "admin":
                staff = new AdminStaff(staffID, name);
                break;
            case "nurse":
                staff = new NursingStaff(staffID, name);
                break;
            case "maintenance":
                staff = new MaintenanceStaff(staffID, name);
                break;
            case "supervisor":
                staff = new NursingSupervisor(staffID, name);
                break;
            default:
                System.out.println("❌ Invalid role.");
                return;
        }

        System.out.print("Enter Shift Date (YYYY-MM-DD): ");
        String date = scanner.nextLine();

        System.out.print("Enter Shift Time (e.g., 08:00-16:00): ");
        String time = scanner.nextLine();

        Schedule schedule = new Schedule(date, time, staff);
        boolean added = rosterManager.addScheduleToRoster(rosterID, schedule);

        if (added) {
            System.out.println("✅ Schedule added successfully.");
        } else {
            System.out.println("❌ Roster not found.");
        }
    }
}
