package admission.control;

public class InputParser {
    public ParsedInput parse(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println("Error: Empty input");
            return null;
        }

        String[] parts = input.trim().split("\\s+");
        if (parts.length == 0) {
            System.out.println("Error: Invalid command format");
            return null;
        }

        String command = parts[0].toLowerCase();
        String[] arguments = new String[parts.length - 1];
        System.arraycopy(parts, 1, arguments, 0, parts.length - 1);

        return new ParsedInput(command, arguments);
    }
} 