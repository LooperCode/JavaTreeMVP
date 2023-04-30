package ui.Commands;

import ui.Console;

public class GetOnce implements Command {
    private Console console;

    public GetOnce(Console console) {
        this.console = console;
    }

    public String getDescription(){
        return "Выберите семейство по ID";
    }

    public void execute(){
        console.getOnce();
    }
}
