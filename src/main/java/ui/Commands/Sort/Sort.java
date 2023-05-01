package ui.Commands.Sort;

import ui.Commands.Command;
import ui.Console;
import ui.Menu.ChoiceSortMenu;

public class Sort implements Command {
    private Console console;

    public Sort (Console console) {

        this.console = console;
    }

    public String getDescription(){

        return "Сортировка текущего дерева";
    }

    public void execute(){
        console.setMenu(new ChoiceSortMenu(console));
        console.menuPrint();
        console.getChoiceSort();
    }
}
