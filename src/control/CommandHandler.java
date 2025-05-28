package control;

import java.util.*;
import manager.AdmissionManager;

public class CommandHandler {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandHandler() {
        commands.put("admit", new AdmitCommand());
        commands.put("add", new AdmitCommand());
        commands.put("discharge", new DischargeCommand());
        commands.put("remove", new DischargeCommand());
        commands.put("list", new ListResidentsCommand());
        commands.put("beds", new BedsCommand()); // ✅ Register beds command
    }

    public CommandResponse execute(String command, String[] args, AdmissionManager manager) {
        Command cmd = commands.get(command);
        if (cmd == null) {
            return new CommandResponse("Invalid command! Type 'help'", false);
        }
        return cmd.execute(manager, args);
    }

    public String getHelp() {
        return "\nAvailable Commands:\n" +
               "  admit <name> <dd/MM/yyyy> <contact> - Add new resident\n" +
               "  discharge <residentID> - Discharge resident\n" +
               "  list - Show all residents\n" +
               "  beds - List available beds\n" +
               "  exit - Quit application\n";
    }

    public ParsedInput parse(String input) {
        String[] tokens = input.trim().split("\\s+");
        String command = tokens[0].toLowerCase();
        String[] args = Arrays.copyOfRange(tokens, 1, tokens.length);
        return new ParsedInput(command, args);
    }


}
