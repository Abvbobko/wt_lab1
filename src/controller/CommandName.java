package controller;

import view.impl.ConsoleView;

import java.util.HashMap;
import java.util.Map;

public enum CommandName {
    HELP(0, "Show commands"), SIGN_IN(1, "Sign In"), REGISTRATION(2, "Register"), ADD_FLIGHT(3, "Add flight"),
    EXIT(4, "Exit");

    private final int id;
    private final String name;

    private static final Map<Integer, CommandName> commandsID = new HashMap<>();
    //private static int[] commandsID;

    static {
        for (CommandName commandName:
             CommandName.values()) {
            commandsID.put(commandName.id, commandName);
        }
    }

    CommandName(int id, String name) {
       // if (id == ConsoleView.HELP_COMMAND_NUMBER) {
        //    throw new Exception();
        //}*/ // ToDo: Сделать чтобы нельзя == 0
        this.id = id;
        //commandsID.put(id, this);
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static CommandName getValueFromID(int id){
        return commandsID.get(id);
    }
}
