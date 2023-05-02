package ui.Command.Commands.Sort;

import ui.Command.Command;
import ui.Console;
import ui.Menu.VarMenu.MainMenu;

public class SortByName implements Command {
    private Console console;

    public SortByName(Console console) {
        this.console = console;
    }

    public String getDescription(){

        return "Сортировка по алфавиту";
    }

    public void execute(){
        console.sortByName();
        console.setMenu(new MainMenu(console));
    }
}
