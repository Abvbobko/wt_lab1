package view.impl;

import controller.Commands;
import controller.Controller;
import view.View;

import java.util.Scanner;

public class ConsoleView implements View {

    private Controller controller = new Controller();

    private void showListOfCommands(){
        Commands.CommandName[] commands = controller.getListOfCommands();
        boolean isAdminMode = controller.isAdminMode();
        for (Commands.CommandName command: commands) {
            if ((isAdminMode) || (command.isForOrdinaryUser())){
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

           // try {
                String input = in.nextLine();
                commandNumber = Integer.parseInt(input);

                if (commandNumber > Commands.CommandName.values().length){
                    commandNumber = Commands.getID(Commands.CommandName.HELP);
                }
                else if ((Commands.getValueFromID(commandNumber) != Commands.CommandName.HELP)
                        &&(Commands.getValueFromID(commandNumber) != Commands.CommandName.EXIT)){

                    String parameters = controller.getCommandArguments(commandNumber);
                    if (!parameters.equals("")) {
                        System.out.println("Please, enter this parameters by spaces: " + parameters);

                        parameters = in.nextLine();
                    }
                    else {
                        parameters = "";
                    }

                    System.out.println(controller.executeTask(commandNumber, parameters));

                }

         //   }
          //  catch (RuntimeException e) {
           //     System.out.println(e.getMessage());
           // }

        }
    }
}
