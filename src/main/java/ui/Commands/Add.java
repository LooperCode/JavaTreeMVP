package ui.Commands;

import ui.Console;

public class Add implements Command{
    private Console console;

    public Add(Console console) {
        this.console = console;
    }

    public String getDescription(){
        return "Добавить человека в дерево";
    }

    public void execute(){
        console.add();
    }
}
