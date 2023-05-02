package ui.Command.Commands.Sort;

import ui.Command.Command;
import ui.Console;
import ui.Menu.VarMenu.MainMenu;

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
        console.setMenu(new MainMenu(console));
    }
}
