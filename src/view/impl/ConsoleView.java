package view.impl;

import controller.CommandName;
import controller.Controller;
import view.View;

import java.util.Scanner;

public class ConsoleView implements View {

    private Controller controller = new Controller();

    private void createListOfCommands(){
        CommandName[] commands = controller.getListOfCommands();
        for (CommandName command: commands) {
            System.out.println(String.format("%d. %s;", command.getID(), command.getName()));
        }
    }


    public void start(){
        System.out.println("Welcome to our airline.");
        System.out.println("Please, choose command:");
        createListOfCommands();

        //ToDO: получить строку введенную пользователем, получить из нее аргументы и команду и передать в контроллер
        //CommandName command = CommandName.HELP;
        int commandNumber = CommandName.HELP.getID();
        Scanner in = new Scanner(System.in);
        while (commandNumber != CommandName.EXIT.getID()) {
            if (commandNumber == CommandName.HELP.getID()) {
                createListOfCommands();
            }
            try {
                commandNumber = in.nextInt();
                if (commandNumber > CommandName.values().length){
                    commandNumber = CommandName.HELP.getID();
                }

            }
            catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
