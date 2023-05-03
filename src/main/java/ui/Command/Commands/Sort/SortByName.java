package ui.Command.Commands.Sort;

import ui.Command.Command;
import ui.Command.Receiver;
import ui.Console;
import ui.Menu.VarMenu.MainMenu;

public class SortByName implements Command {
    private Receiver receiver;

    public SortByName(Receiver receiver) {

        this.receiver = receiver;
    }

    public String getDescription(){

        return "Сортировка по алфавиту";
    }

    public void execute(){

        receiver.sortByName();
    }
}
