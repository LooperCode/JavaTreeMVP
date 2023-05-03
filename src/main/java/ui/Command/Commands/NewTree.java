package ui.Command.Commands;

import ui.Command.Command;
import ui.Command.Receiver;
import ui.Console;

public class NewTree implements Command {
    private Receiver receiver;

    public NewTree(Receiver receiver) {

        this.receiver = receiver;
    }

    public String getDescription(){

        return "Добавить новое дерево";
    }

    public void execute(){

        receiver.newTree();
    }
}
