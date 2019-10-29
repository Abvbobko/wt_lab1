package controller;

import beans.User;
import service.ClientService;
import service.factory.ServiceFactory;

public final class Controller {

    ServiceFactory serviceFactory = ServiceFactory.getInstance();
    ClientService clientService = serviceFactory.getClientService();

    private final CommandProvider provider = new CommandProvider();
  //  private User currentUser = null;

  //  private final char paramDelimeter = ' ';

    public String executeTask(int commandNumber, String request){
    //    String commandName;
        Commands.CommandName commandName = Commands.getValueFromID(commandNumber);
        Command executionCommand;
        //request.substring(0, request.indexOf(paramDelimeter));

        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;
    }

    public String getCommandArguments(int commandNumber){
        Commands.CommandName commandName = Commands.getValueFromID(commandNumber);
        return ((ConsoleCommand)provider.getCommand(commandName)).getParametersInfo();
    }

    public int getNumberOfCommands() {
        return Commands.CommandName.values().length;
    }

    public Commands.CommandName[] getListOfCommands() {
        return Commands.CommandName.values();
    }

    public boolean isAdminMode(){
        return clientService.isAdminMode();
    }
}