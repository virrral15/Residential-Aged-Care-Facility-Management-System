package control;

import java.util.Arrays;

public class InputParser {

    public ParsedInput parse(String input) {
        String[] tokens = input.trim().split(" ");
        return new ParsedInput(tokens[0].toLowerCase(), Arrays.copyOfRange(tokens, 1, tokens.length));
    }
}
