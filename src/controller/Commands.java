package controller;

import java.util.HashMap;
import java.util.Map;

public class Commands{
    public enum CommandName {
        HELP("Show commands", true),
        SIGN_IN("Sign In", true),
        SIGN_OUT("Sign Out", true),
        REGISTRATION("Register", true),
        ADD_FLIGHT("Add flight", false),
        BUY_TICKET("Buy ticket", true),
        SHOW_TICKETS("Show tickets", true),
        EXIT("Exit", true);

        private final String name;
        private final boolean forOrdinaryUser;

        CommandName(String name, Boolean forOrdinaryUser) {
            this.name = name;
            this.forOrdinaryUser = forOrdinaryUser;
        }

        public String getName() {
            return name;
        }

        public boolean isForOrdinaryUser(){
            return this.forOrdinaryUser;
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

