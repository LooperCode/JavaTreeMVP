package ui.Commands;

import ui.Console;

public class NewTree implements Command {
    private Console console;

    public NewTree(Console console) {
        this.console = console;
    }

    public String getDescription(){
        return "Добавить новое дерево";
    }

    public void execute(){
        console.newTree();
    }
}
