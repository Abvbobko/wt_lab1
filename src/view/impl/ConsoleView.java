package view.impl;

import controller.Commands;
import controller.Controller;
import view.View;

import java.util.Scanner;

public class ConsoleView implements View {

    private Controller controller = new Controller();

    /**
     * Method print list of available commands
     */
    private void showListOfCommands(){
        Commands.CommandName[] commands = controller.getListOfCommands();
        boolean isAdminMode = controller.isAdminMode();
        for (Commands.CommandName command: commands) {
            if ((isAdminMode) || (command.isForOrdinaryUser())){
                System.out.println(String.format("%d. %s;", Commands.getID(command), command.getName()));
            }
        }
    }

    /**
     * Entry point of view
     */
    public void start(){
        System.out.println("Welcome to our airline.");
        System.out.println("Please, choose command:");

        // to display the menu first
        int commandNumber = Commands.getID(Commands.CommandName.HELP);
        Scanner in = new Scanner(System.in);

        while (Commands.getValueFromID(commandNumber) != Commands.CommandName.EXIT) {

            if (commandNumber == Commands.getID(Commands.CommandName.HELP)) {
                showListOfCommands();
            }

            try {
                String input = in.nextLine();
                commandNumber = Integer.parseInt(input);

                if (commandNumber > Commands.CommandName.values().length){
                    commandNumber = Commands.getID(Commands.CommandName.HELP);
                }
                else if ((Commands.getValueFromID(commandNumber) != Commands.CommandName.HELP)
                        &&(Commands.getValueFromID(commandNumber) != Commands.CommandName.EXIT)){

                    String parameters = controller.getCommandArguments(commandNumber);
                    if (!parameters.equals("")) {
                        // if method need arguments he return info about them

                        System.out.println("Please, enter this parameters by spaces: " + parameters);
                        parameters = in.nextLine();
                    }

                    System.out.println(controller.executeTask(commandNumber, parameters));
                    commandNumber = Commands.getID(Commands.CommandName.HELP);
                }

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
