package control;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommandInvoker {
    private final Map<Integer, Command> commandMap;

    public CommandInvoker(Scanner scanner) {
        commandMap = new HashMap<>();

        //  Resident Management
        commandMap.put(1, new AdmitResidentCommand(scanner));
        commandMap.put(2, new DischargeResidentCommand(scanner));
        commandMap.put(3, new ListResidentsCommand());
        
        // Room Management
        commandMap.put(4, new AllocateRoomCommand(scanner));
        commandMap.put(5, new ReleaseRoomCommand(scanner));
        commandMap.put(6, new ViewRoomStatusCommand());
        commandMap.put(7, new MarkRoomUnderMaintenanceCommand(scanner));
        commandMap.put(8, new MarkRoomAvailableCommand(scanner));  
        
        // Equipment Management
        commandMap.put(9, new AllocateEquipmentCommand(scanner));
        commandMap.put(10, new ReportFaultyEquipmentCommand(scanner));
        commandMap.put(11, new ViewEquipmentStatusCommand());

        // Roster Management
        commandMap.put(12, new CreateRosterCommand(scanner));
        commandMap.put(13, new AddScheduleCommand(scanner));
        commandMap.put(14, new UpdateShiftCommand(scanner));
        commandMap.put(15, new ViewRosterCommand(scanner));



        //  Room, Equipment, Roster — to be added in next steps
    }

    public Command getCommand(int choice) {
        return commandMap.get(choice);
    }
}
