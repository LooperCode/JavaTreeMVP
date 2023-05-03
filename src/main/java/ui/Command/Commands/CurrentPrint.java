package ui.Command.Commands;

import ui.Command.Command;
import ui.Command.Receiver;
import ui.Console;

public class CurrentPrint implements Command {
    private Receiver receiver;

    public CurrentPrint(Receiver receiver) {

        this.receiver = receiver;
    }

    public String getDescription(){

        return "Вывести на экран текущее дерево";
    }

    public void execute(){

        receiver.currentPrint();
    }
}
