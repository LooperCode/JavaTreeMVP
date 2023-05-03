package ui.Command.Commands;

import ui.Command.Command;
import ui.Command.Receiver;
import ui.Console;

public class GetByFamily implements Command {
    private Receiver receiver;

    public GetByFamily(Receiver receiver) {

        this.receiver = receiver;
    }

    public String getDescription(){

        return "Поиск семейства по фамилии";
    }

    public void execute(){

        receiver.getByFamily();
    }
}
