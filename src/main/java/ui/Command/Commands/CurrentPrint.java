package ui.Command.Commands;

import ui.Command.Command;
import ui.Console;

public class CurrentPrint implements Command {
    private Console console;

    public CurrentPrint(Console console) {

        this.console = console;
    }

    public String getDescription(){

        return "Вывести на экран текущее дерево";
    }

    public void execute(){

        console.currentPrint();
    }
}
