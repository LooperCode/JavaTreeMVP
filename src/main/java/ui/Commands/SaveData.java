package ui.Commands;

import ui.Console;

public class SaveData implements Command {
    private Console console;

    public SaveData(Console console) {
        this.console = console;
    }

    public String getDescription(){
        return "Сохранить дерево";
    }

    public void execute(){
        console.saveData();
    }
}
