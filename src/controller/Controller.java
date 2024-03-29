package controller;

import service.ClientService;
import service.factory.ServiceFactory;

public final class Controller {

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ClientService clientService = serviceFactory.getClientService();

    private final CommandProvider provider = new CommandProvider();

    public String executeTask(int commandNumber, String request){

        Commands.CommandName commandName = Commands.getValueFromID(commandNumber);
        Command executionCommand;

        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);

        return response;
    }

    public String getCommandArguments(int commandNumber){
        Commands.CommandName commandName = Commands.getValueFromID(commandNumber);
        if (commandName == null) {
            throw new NullPointerException("There is no such command number.");
        }
        return ((ConsoleCommand)provider.getCommand(commandName)).getParametersInfo();
    }

    public Commands.CommandName[] getListOfCommands() {
        return Commands.CommandName.values();
    }

    public boolean isAdminMode(){
        return clientService.isAdminMode();
    }
}