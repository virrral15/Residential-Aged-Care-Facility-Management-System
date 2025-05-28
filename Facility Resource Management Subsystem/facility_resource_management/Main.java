package facility_resource_management;

public class Main {
    public static void main(String[] args) {
        CommandInvoker invoker = new CommandInvoker();

        // Shared instance of RosterManager
        RosterManager rosterManager = new RosterManager();

        // ----------------- Room Management Commands -----------------
        invoker.registerCommand(1, new AllocateRoomCommand());
        invoker.registerCommand(2, new ReleaseRoomCommand());
        invoker.registerCommand(3, new DisplayRoomStatusCommand());
        invoker.registerCommand(4, new MarkRoomUnderMaintenanceCommand());
        invoker.registerCommand(5, new MarkRoomAvailableCommand());

        // ----------------- Equipment Management Commands -----------------
        invoker.registerCommand(6, new AllocateEquipmentCommand());
        invoker.registerCommand(7, new ReportFaultyEquipmentCommand());
        invoker.registerCommand(8, new DisplayEquipmentStatusCommand());

        // ----------------- Roster Management Commands -----------------
        invoker.registerCommand(9, new CreateRosterCommand(rosterManager));
        invoker.registerCommand(10, new AddScheduleToRosterCommand(rosterManager));
        invoker.registerCommand(11, new UpdateShiftCommand(rosterManager));
        invoker.registerCommand(12, new DisplayRosterCommand(rosterManager));

        // ----------------- Start Program -----------------
        invoker.run();
    }
}
