package view.impl;

import controller.Commands;
import controller.Controller;
import view.View;

import java.util.Scanner;

public class ConsoleView implements View {

    private Controller controller = new Controller();

    private void showListOfCommands(){
        Commands.CommandName[] commands = controller.getListOfCommands();
        for (Commands.CommandName command: commands) {
            if (command.isForOrdinaryUser() && !controller.isAdminMode()){
                System.out.println(String.format("%d. %s;", Commands.getID(command), command.getName()));
            }
            else if (controller.isAdminMode()){
                System.out.println(String.format("%d. %s;", Commands.getID(command), command.getName()));
            }
        }
    }

    public void start(){
        System.out.println("Welcome to our airline.");
        System.out.println("Please, choose command:");

        int commandNumber = Commands.getID(Commands.CommandName.HELP);
        Scanner in = new Scanner(System.in);

        while (Commands.getValueFromID(commandNumber) != Commands.CommandName.EXIT) {
            if (commandNumber == Commands.getID(Commands.CommandName.HELP)) {
                showListOfCommands();
            }
            try {
                commandNumber = in.nextInt();

                if (commandNumber > Commands.CommandName.values().length){
                    commandNumber = Commands.getID(Commands.CommandName.HELP);
                }
                else {
                    String parameters = controller.getCommandArguments(commandNumber);
                    if (!parameters.equals("")) {
                        System.out.println("Please, enter this parameters by spaces: \n" + parameters);
                        parameters = in.nextLine();
                    }
                    else {
                        parameters = "";
                    }
                    controller.executeTask(commandNumber, parameters);
                }

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
