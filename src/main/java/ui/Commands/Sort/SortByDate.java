package ui.Commands.Sort;

import ui.Commands.Command;
import ui.Console;

public class SortByDate implements Command {
    private Console console;

    public SortByDate(Console console) {

        this.console = console;
    }

    public String getDescription(){

        return "Сортировка по дате рождения";
    }

    public void execute(){

        console.sortByDate();
    }
}
