package FRMS;

public class Main {
    public static void main(String[] args) {
        CommandInvoker invoker = new CommandInvoker();
        RosterManager rosterManager = new RosterManager();

        // Register available commands
        invoker.registerCommand(1, new AllocateRoomCommand());
        invoker.registerCommand(2, new ReleaseRoomCommand());
        invoker.registerCommand(3, new DisplayRoomStatusCommand());
        invoker.registerCommand(4, new AllocateEquipmentCommand());
        invoker.registerCommand(5, new ReportFaultyEquipmentCommand());
        invoker.registerCommand(6, new DisplayEquipmentStatusCommand());
        
        // Roster management commands
        invoker.registerCommand(7, new CreateRosterCommand(rosterManager));
        invoker.registerCommand(8, new AddScheduleToRosterCommand(rosterManager));
        invoker.registerCommand(9, new UpdateShiftCommand(rosterManager));
        invoker.registerCommand(10, new DisplayRosterCommand(rosterManager));

        // Run the menu
        invoker.run();
    }
}
