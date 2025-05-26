package admission.control;

public class ParsedInput {
    private final String command;
    private final String[] arguments;

    public ParsedInput(String command, String[] arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArguments() {
        return arguments;
    }

    public int getArgumentCount() {
        return arguments.length;
    }

    public String getArgument(int index) {
        if (index >= 0 && index < arguments.length) {
            return arguments[index];
        }
        return null;
    }
} 