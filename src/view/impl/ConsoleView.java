package view.impl;

import controller.CommandName;
import controller.Controller;
import view.View;

public class ConsoleView implements View {

    private static final int HELP_COMMAND_NUMBER = 0;
    private static final String HELP_COMMAND_NAME = "Show commands";

    private Controller controller = new Controller();

    private void createListOfCommands(){
        CommandName[] commands = controller.getListOfCommands();
        for (CommandName command: commands) {
            System.out.println(String.format("%d. %s;", command.getID(), command.getName()));
        }
        System.out.println(String.format("%d. %s;", HELP_COMMAND_NUMBER, HELP_COMMAND_NAME));
    }

    //ToDO: Add in menu Help

    public void start(){
        System.out.println("Welcome to our airline.");
        System.out.println("Please, choose command:");
        createListOfCommands();

    }
}
