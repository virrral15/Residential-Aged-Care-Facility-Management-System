package admission.control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommandHandler {
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Command createCommand(ParsedInput input) {
        try {
            switch (input.getCommand()) {
                case "admit":
                    if (input.getArgumentCount() != 3) {
                        System.out.println("Error: Admit command requires name, date of birth (dd/MM/yyyy), and contact info");
                        return null;
                    }
                    String name = input.getArgument(0);
                    Date dob = dateFormat.parse(input.getArgument(1));
                    String contact = input.getArgument(2);
                    return new AdmitCommand(name, dob, contact);

                case "discharge":
                    if (input.getArgumentCount() != 1) {
                        System.out.println("Error: Discharge command requires resident ID");
                        return null;
                    }
                    return new DischargeCommand(input.getArgument(0));

                case "list":
                    if (input.getArgumentCount() != 0) {
                        System.out.println("Error: List command takes no arguments");
                        return null;
                    }
                    return new ListResidentsCommand();

                case "beds":
                    if (input.getArgumentCount() != 0) {
                        System.out.println("Error: Beds command takes no arguments");
                        return null;
                    }
                    return new BedsCommand();

                default:
                    System.out.println("Error: Unknown command: " + input.getCommand());
                    return null;
            }
        } catch (ParseException e) {
            System.out.println("Error: Invalid date format. Use dd/MM/yyyy");
            return null;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return null;
        }
    }
} 