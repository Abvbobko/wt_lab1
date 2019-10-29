package controller;

import javafx.util.Pair;
import view.impl.ConsoleView;

import java.util.HashMap;
import java.util.Map;

public class CommandName{
    private enum Commands {
        HELP("Show commands"),
        SIGN_IN("Sign In"),
        SIGN_OUT("Sign Out"),
        REGISTRATION("Register"),
        ADD_FLIGHT("Add flight"),
        BUY_TICKET("Buy ticket"),
        EXIT("Exit");

        private final String name;

        Commands(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    private static final Map<Integer, Commands> commands = new HashMap<>();
    private static final CommandName instance = new CommandName();

    private CommandName(){
        int i = 0;
        for (Commands command:
             Commands.values()) {
            commands.put(i++, command);
        }
    }

    public static Commands getValueFromID(int id){
        return commands.get(id);
    }

    public static CommandName getInstance(){
        return instance;
    }
}

