package controller;

import controller.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {

    private final Map<Commands.CommandName, ConsoleCommand> repository = new HashMap<>();

    CommandProvider(){

        repository.put(Commands.CommandName.SIGN_IN, new SignIn());
        repository.put(Commands.CommandName.REGISTRATION, new Register());
        repository.put(Commands.CommandName.ADD_FLIGHT, new AddFlight());
        repository.put(Commands.CommandName.REMOVE_FLIGHT, new RemoveFlight());
        repository.put(Commands.CommandName.SIGN_OUT, new SignOut());
        repository.put(Commands.CommandName.BUY_TICKET, new BuyTicket());
        repository.put(Commands.CommandName.RETURN_TICKET, new ReturnTicket());
        repository.put(Commands.CommandName.SHOW_TICKETS, new ShowTickets());
        //repository.put(CommandName.WRONG_REQUEST, new WrongRequest());

    }

    Command getCommand(Commands.CommandName commandName){

        ConsoleCommand command = null;
        try{
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){
            //write log
            //command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}