package ui.Command.Commands.Sort;

import ui.Command.Command;
import ui.Command.Receiver;

public class Sort implements Command {
    private Receiver receiver;

    public Sort (Receiver receiver) {

        this.receiver = receiver;
    }

    public String getDescription(){

        return "Сортировка текущего дерева";
    }

    public void execute(){

        receiver.getChoiceSort();
    }
}
