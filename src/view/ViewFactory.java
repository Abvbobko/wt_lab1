package view;

import view.impl.ConsoleView;

public final class ViewFactory {
    private static final ViewFactory instance = new ViewFactory();
    private final ConsoleView consoleView = new ConsoleView();

    private ViewFactory(){}

    public static ViewFactory getInstance(){
        return instance;
    }


    public ConsoleView getConsoleView(){
        return consoleView;
    }
}