package controller;

public final class Controller {

    //ToDo: Controller factory
    private final CommandProvider provider = new CommandProvider();

    private final char paramDelimeter = ' ';

    public String executeTask(String request){
        String commandName;

        Command executionCommand;
        commandName = request.substring(0, request.indexOf(paramDelimeter));
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