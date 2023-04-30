package ui.Commands.Sort;

import ui.Commands.Command;
import ui.Console;

public class Sort implements Command {
    private Console console;

    public Sort (Console console) {

        this.console = console;
    }

    public String getDescription(){

        return "Сортировка текущего дерева";
    }

    public void execute(){

        console.getChoiceSort();
    }
}
