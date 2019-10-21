package controller;

import beans.User;

public final class Controller {

    private final CommandProvider provider = new CommandProvider();
  //  private User currentUser = null;

    private final char paramDelimeter = ' ';

    public String executeTask(int commandNumber, String request){
    //    String commandName;
        CommandName commandName = CommandName.getValueFromID(commandNumber);
        Command executionCommand;
        //request.substring(0, request.indexOf(paramDelimeter));

        executionCommand = provider.getCommand(commandName);
        String response;
        response = executionCommand.execute(request);
        return response;
    }

    public int getNumberOfCommands() {
        return CommandName.values().length;
    }

    public CommandName[] getListOfCommands() {
        return CommandName.values();
    }

}