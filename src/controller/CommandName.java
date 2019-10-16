package controller;

import view.impl.ConsoleView;

public enum CommandName {
    SIGN_IN(1, "Sign In"), REGISTRATION(2, "Register"), ADD_FLIGHT(3, "Add flight");

    private final int id;
    private final String name;

    CommandName(int id, String name) {
       // if (id == ConsoleView.HELP_COMMAND_NUMBER) {
        //    throw new Exception();
        //}*/ // ToDo: Сделать чтобы нельзя == 0
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return id;
    }

    public String getName() {
        return name;
    }
}
