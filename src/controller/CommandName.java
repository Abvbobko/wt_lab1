package controller;

public enum CommandName {
    SIGN_IN(1, "Sign In"), REGISTRATION(2, "Register"), ADD_FLIGHT(3, "Add flight");

    private final int value;
    private final String name;

    CommandName(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
