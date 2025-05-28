package control;

import entity.*;
import manager.AdmissionManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdmitCommand implements Command {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public CommandResponse execute(AdmissionManager manager, String[] args) {
        if (args.length < 3) {
            return new CommandResponse("Error: Please provide name, date of birth (dd/MM/yyyy), and contact", false);
        }
        
        try {
            Date dob = DATE_FORMAT.parse(args[1]);
            Resident resident = manager.admitResident(args[0], dob, args[2]);
            return new CommandResponse(
                "Admitted! ID: " + resident.getResidentID() + 
                (resident.getAssignedBed() != null ? " | Bed: " + resident.getAssignedBed().getBedID() : ""), 
                true
            );
        } catch (ParseException e) {
            return new CommandResponse("Invalid date format (dd/MM/yyyy)", false);
        } catch (Exception e) {
            return new CommandResponse(e.getMessage(), false);
        }
    }
}
