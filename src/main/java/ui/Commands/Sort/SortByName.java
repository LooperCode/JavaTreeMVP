package ui.Commands.Sort;

import ui.Commands.Command;
import ui.Console;

public class SortByName implements Command {
    private Console console;

    public SortByName(Console console) {
        this.console = console;
    }

    public String getDescription(){

        return "Сортировка по имени";
    }

    public void execute(){

        console.sortByName();
    }
}
