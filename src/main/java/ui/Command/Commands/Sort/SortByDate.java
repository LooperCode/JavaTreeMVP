package ui.Command.Commands.Sort;

import ui.Command.Command;
import ui.Command.Receiver;
import ui.Console;
import ui.Menu.VarMenu.MainMenu;

public class SortByDate implements Command {
    private Receiver receiver;

    public SortByDate(Receiver receiver) {

        this.receiver = receiver;
    }

    public String getDescription(){

        return "Сортировка по дате рождения";
    }

    public void execute(){
        receiver.sortByDate();

    }
}
