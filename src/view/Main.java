package view;

public class Main {
    public static void main(String[] args) {

        View view = ViewFactory.getInstance().getConsoleView();
        view.start();
    }

}

