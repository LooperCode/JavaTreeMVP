package ui.Command.Commands;

import ui.Command.Command;
import ui.Command.Receiver;
import ui.Console;

public class Add implements Command {
    private Receiver receiver;

    public Add(Receiver receiver) {

        this.receiver = receiver;
    }

    public String getDescription(){

        return "Добавить человека в дерево";
    }

    public void execute() {

        receiver.add();

    }
}
