package ui.Command.Commands;

import ui.Command.Command;
import ui.Command.Receiver;
import ui.Console;

public class SaveData implements Command {
    private Receiver receiver;

    public SaveData(Receiver receiver) {

        this.receiver = receiver;
    }

    public String getDescription(){

        return "Сохранить дерево";
    }

    public void execute(){

        receiver.saveData();
    }
}
