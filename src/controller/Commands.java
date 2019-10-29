package controller;

import javafx.util.Pair;
import view.impl.ConsoleView;

import java.util.HashMap;
import java.util.Map;

public class Commands{
    public enum CommandName {
        HELP("Show commands"),
        SIGN_IN("Sign In"),
        SIGN_OUT("Sign Out"),
        REGISTRATION("Register"),
        ADD_FLIGHT("Add flight"),
        BUY_TICKET("Buy ticket"),
        EXIT("Exit");

        private final String name;

        CommandName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    private static final Map<Integer, CommandName> commands = new HashMap<>();
    private static final Commands instance = new Commands();

    private Commands(){
        int i = 0;
        for (CommandName command:
             CommandName.values()) {
            commands.put(i++, command);
        }
    }

    public static CommandName getValueFromID(int id){
        return commands.get(id);
    }

    public static int getID(CommandName command){
        for (Integer key:
             commands.keySet()) {
            if (commands.get(key).equals(command)){
                return key;
            }
        }

        //ToDo throw error
        return 0;
    }

    public static Commands getInstance(){
        return instance;
    }
}

