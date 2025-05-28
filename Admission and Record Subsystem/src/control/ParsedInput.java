package control;

public class ParsedInput {
    private String command;
    private String[] args;
    
    public ParsedInput(String command, String[] args) {
        this.command = command;
        this.args = args;
    }

	public String getCommand() {
        return command;
    }

    public String[] getArgs() {
        return args;
    }

}
