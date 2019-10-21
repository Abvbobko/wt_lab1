package view.impl;

import controller.CommandName;
import controller.Controller;
import view.View;

import java.util.Scanner;

public class ConsoleView implements View {

    private Controller controller = new Controller();

    private void showListOfCommands(){
        CommandName[] commands = controller.getListOfCommands();
        for (CommandName command: commands) {
            System.out.println(String.format("%d. %s;", command.getID(), command.getName()));
        }
    }

    public void start(){
        System.out.println("Welcome to our airline.");
        System.out.println("Please, choose command:");

        //ToDO: получить строку введенную пользователем, получить из нее аргументы и команду и передать в контроллер
        int commandNumber = CommandName.HELP.getID();
        Scanner in = new Scanner(System.in);
        while (commandNumber != CommandName.EXIT.getID()) {
            if (commandNumber == CommandName.HELP.getID()) {
                showListOfCommands();
            }
            try {
                commandNumber = in.nextInt();

                if (commandNumber > CommandName.values().length){
                    commandNumber = CommandName.HELP.getID();
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
