package controller;

import controller.impl.AddFlight;
import controller.impl.Register;
import controller.impl.SignIn;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandName.SIGN_IN, new SignIn());
        repository.put(CommandName.REGISTRATION, new Register());
        repository.put(CommandName.ADD_FLIGHT, new AddFlight());
        //repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
//...
    }

    Command getCommand(String name){
        CommandName commandName =null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        }catch(IllegalArgumentException | NullPointerException e){
//write log
            //command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}