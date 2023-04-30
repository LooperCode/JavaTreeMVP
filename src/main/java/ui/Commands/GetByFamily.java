package ui.Commands;

import ui.Console;

public class GetByFamily implements Command {
    private Console console;

    public GetByFamily(Console console) {

        this.console = console;
    }

    public String getDescription(){

        return "Поиск семейства по фамилии";
    }

    public void execute(){

        console.getByFamily();
    }
}
