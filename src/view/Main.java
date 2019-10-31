package view;

// ToDo: Add Java Beans form for all classes

import view.impl.ConsoleView;

public class Main {
    public static void main(String[] args) {

        View view = ViewFactory.getInstance().getConsoleView();
        view.start();
    }

}

